package net.zhaoxuyang.demo.asm;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * 访问一个类
 * @author zhaoxuyang
 */
public class MyClassVisitor extends ClassVisitor {
    public static void main(String[] args) throws IOException{
        String name = HashMap.class.getName().replace(".", "/") + ".class";
        System.out.println(name);
        InputStream iStream = ClassLoader.getSystemResourceAsStream(name);
        ClassReader classReader = new ClassReader(iStream);
        MyClassVisitor classPrinter = new MyClassVisitor();
        classReader.accept(classPrinter, 0);
    }

    public MyClassVisitor() {
        super(Opcodes.ASM7);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        System.out.println("[visit] name: " + name + "  superName: " + superName + "  interfaces: " + Arrays.toString(interfaces));
    }

    @Override
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
        System.out.println("[visitField] name: " + name + "  descriptor: " + descriptor);
        return null;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        System.out.println("[visitorMethod] name: " + name + "  descriptor: " + descriptor);
        return null;
    }
    
}
