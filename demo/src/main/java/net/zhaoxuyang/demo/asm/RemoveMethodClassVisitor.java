package net.zhaoxuyang.demo.asm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import static org.objectweb.asm.Opcodes.ASM7;

/**
 *
 * @author zhaoxuyang
 */
public class RemoveMethodClassVisitor extends ClassVisitor {

    public static void main(String[] args) throws IOException {
        ClassWriter cw = new ClassWriter(3);
        RemoveMethodClassVisitor cv = new RemoveMethodClassVisitor(cw);
        ClassReader cr = new ClassReader("net.zhaoxuyang.demo.asm.User");
        cr.accept(cv, 0);

        File file = new File("net/zhaoxuyang/demo/asm/User.class");
        file.getParentFile().mkdirs();
        file.createNewFile();
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(cw.toByteArray());
        }
    }

    public RemoveMethodClassVisitor(ClassWriter cw) {
        super(ASM7, cw);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        if (name.startsWith("go")) {
            return null;
        }
        return cv.visitMethod(access, name, descriptor, signature, exceptions);
    }

}
