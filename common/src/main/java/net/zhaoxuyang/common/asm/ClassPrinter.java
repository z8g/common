package net.zhaoxuyang.common.asm;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * 访问一个类
 * @author zhaoxuyang
 */
public class ClassPrinter extends ClassVisitor {

    public ClassPrinter() {
        super(Opcodes.ASM7);
    }

    @Override
    public void visit(int version, int access, String name, String signature,
            String superName, String[] interfaces) {
        System.out.println("visit:");
        System.out.println("version: " + version);
        System.out.println("access: " + access);
        System.out.println("name: " + name);
        System.out.println("signature: " + signature);
        System.out.println("superName: " + superName);
        System.out.println("interfaces: " + Arrays.toString(interfaces));
    }

    @Override
    public FieldVisitor visitField(int access, String name, String descriptor,
            String signature, Object value) {
        System.out.println("visitField:");
        System.out.println("access: " + access);
        System.out.println("name: " + name);
        System.out.println("descriptor: " + descriptor);
        System.out.println("signature: " + signature);
        System.out.println("value: " + value);
        return null;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor,
            String signature, String[] exceptions) {
        System.out.println("visitMethod:");
        System.out.println("access: " + access);
        System.out.println("name: " + name);
        System.out.println("descriptor: " + descriptor);
        System.out.println("signature: " + signature);
        System.out.println("exceptions: " + Arrays.toString(exceptions));
        return null;
    }

    public static void main(String[] args) throws IOException {
        ClassPrinter classPrinter = new ClassPrinter();

        String classPath = ClassPrinter.class.getName().replaceAll("\\.", "/") + ".class";
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(classPath);

        ClassReader classReader = new ClassReader(inputStream);
        classReader.accept(classPrinter, 0);
    }
}
