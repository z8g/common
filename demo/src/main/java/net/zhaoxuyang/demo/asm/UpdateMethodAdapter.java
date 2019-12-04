/*
下面是给目标类的所有方法添加计时的代码，使用一个局部变量计时，然后打印时间，纳秒级别的。

使用AnalyzerAdapter计算最大操作数栈，LocalVariablesSorter重新计算局部变量的索引并自动更新字节码中的索引引用。

使用MethodVisitor修改字节码，还可以限定类名，只修改指定类名的类方法。

因为插入了新的局部变量用于计时，所以需要重新定位局部变量。

效果：

原始类：

public class Receiver {
    public void do1(){
        System.out.println("开工12");
    }
}

修改之后的类：
public void do1() {
        long var1 = System.nanoTime();
        System.out.println("开工12");
        var1 = System.nanoTime() - var1;
        System.out.println(var1);
    }
 */
package net.zhaoxuyang.demo.asm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import static org.objectweb.asm.Opcodes.ASM7;
import static org.objectweb.asm.Type.LONG_TYPE;
import org.objectweb.asm.commons.AnalyzerAdapter;
import org.objectweb.asm.commons.LocalVariablesSorter;
import org.objectweb.asm.util.TraceClassVisitor;

/**
 *
 * @author zhaoxuyang
 */
public class UpdateMethodAdapter extends ClassVisitor implements Opcodes {

    public static void main(String[] args) throws IOException {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        TraceClassVisitor tv = new TraceClassVisitor(cw, new PrintWriter(System.out));
        UpdateMethodAdapter addFieldAdapter = new UpdateMethodAdapter(tv);
        ClassReader cr = new ClassReader("net.zhaoxuyang.demo.asm.Receiver");
        cr.accept(addFieldAdapter, ClassReader.EXPAND_FRAMES);

        File file = new File("target/class/net/zhaoxuyang/demo/asm/Receiver.class");
        file.getParentFile().mkdirs();
        file.createNewFile();
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(cw.toByteArray());
        }

    }
    private String owner;
    private boolean isInterface;

    public UpdateMethodAdapter(ClassVisitor cv) {
        super(ASM7, cv);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        owner = name;
        isInterface = (access & ACC_INTERFACE) != 0;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, descriptor, signature, exceptions);

        if (!isInterface && mv != null && !"<init>".equals(name)) {
            AddTimeMethodAdapter adapter = new AddTimeMethodAdapter(mv);
            adapter.aa = new AnalyzerAdapter(owner, access, name, descriptor, adapter);
        }
        return null;
    }

    class AddTimeMethodAdapter extends MethodVisitor {

        private int time;
        private int maxStack;
        public LocalVariablesSorter lvs;
        public AnalyzerAdapter aa;

        AddTimeMethodAdapter(MethodVisitor mv) {
            super(ASM7, mv);
        }

        @Override
        public void visitCode() {
            mv.visitCode();
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "nanoTime", "()J", false);
            time = lvs.newLocal(LONG_TYPE);
            mv.visitVarInsn(LSTORE, time);
            maxStack = 4;
        }

        @Override
        public void visitInsn(int opcode) {
            if ((opcode >= IRETURN && opcode <= RETURN) || opcode == ATHROW) {
                mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "nanoTime", "()J", false);
                mv.visitVarInsn(LLOAD, time);
                mv.visitInsn(LSUB);
                mv.visitVarInsn(LSTORE, time);

                mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/InputStream;");
                mv.visitVarInsn(LLOAD, time);
                mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);
                maxStack = Math.max(aa.stack.size() + 4, maxStack);
            }
            mv.visitInsn(opcode);
        }

        @Override
        public void visitMaxs(int maxStack, int maxLocals) {
            super.visitMaxs(Math.max(maxStack, this.maxStack), maxLocals);
        }

    }
}
