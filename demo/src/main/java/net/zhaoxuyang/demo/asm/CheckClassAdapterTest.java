package net.zhaoxuyang.demo.asm;

import java.io.IOException;
import java.io.PrintWriter;
import jdk.internal.org.objectweb.asm.ClassWriter;
import static jdk.internal.org.objectweb.asm.Opcodes.ACC_ABSTRACT;
import static jdk.internal.org.objectweb.asm.Opcodes.ACC_FINAL;
import static jdk.internal.org.objectweb.asm.Opcodes.ACC_INTERFACE;
import static jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static jdk.internal.org.objectweb.asm.Opcodes.ACC_STATIC;
import static jdk.internal.org.objectweb.asm.Opcodes.V1_8;
import jdk.internal.org.objectweb.asm.util.CheckClassAdapter;
import jdk.internal.org.objectweb.asm.util.TraceClassVisitor;

/**
 * CheckClassAdapter用来检查它的方法调用以及参数是否正确.
 *
 * @author zhaoxuyang
 */
public class CheckClassAdapterTest {

    public static void main(String[] args) throws IOException {

        ClassWriter cw = new ClassWriter(3);
        CheckClassAdapter cca = new CheckClassAdapter(cw);
        TraceClassVisitor tv = new TraceClassVisitor(cca, new PrintWriter(System.out));

        tv.visit(V1_8, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE, "net/zhaoxuyang/Cw0", null, "java/lang/Object", null);
        tv.visitField(ACC_PUBLIC + ACC_STATIC + ACC_FINAL, "LESS", "I", null, -1).visitEnd();
        tv.visitField(ACC_PUBLIC + ACC_STATIC + ACC_FINAL, "EQUAL", "I", null, 0).visitEnd();
        tv.visitField(ACC_PUBLIC + ACC_STATIC + ACC_FINAL, "GRATER", "I", null, 1).visitEnd();

        tv.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "compareTo", "(Ljava/lang/Object;)I", null, null).visitEnd();

        tv.visitEnd();
    }
}
