package net.zhaoxuyang.common.asm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

/**
 * 创建一个类
 *
 * @author zhaoxuyang
 */
public class CW1 {

    public static void main(String[] args) throws MalformedURLException, IOException {
        ClassWriter classWriter = new ClassWriter(0);
        int version = Opcodes.V1_8;
        int access = Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT + Opcodes.ACC_INTERFACE;
        String name = "net/zhaoxuyang/Student";
        String signature = null;
        String superName = "java/lang/Object";
        String[] interfaces = {};
        classWriter.visit(version, access, name, signature, superName, interfaces);

        //classWriter.visitField(access, name, signature, signature, name);
        //classWriter.visitField(access, name, signature, signature, name);
        //classWriter.visitMethod(access, name, signature, signature, interfaces);
        classWriter.visitEnd();

        String systemRootUrl = (new File("")).toURI().toURL().getPath();
        File file = new File(systemRootUrl + name + ".class");
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(classWriter.toByteArray());
        System.out.println(file.getAbsolutePath());

    }
}
