//package net.zhaoxuyang.demo.asm;
//
//public interface Cw0 extends net.zhaoxuyang.demo.asm.UserMapper {
//
//    public static final int LESS = -1;
//    public static final int EQUAL = 0;
//    public static final int GRATER = 1;
//
//    public int compareTo(Object o);
//}

package net.zhaoxuyang.demo.asm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import org.objectweb.asm.ClassWriter;
import static org.objectweb.asm.Opcodes.ACC_ABSTRACT;
import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_INTERFACE;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.V1_8;

/**
 *
 * @author zhaoxuyang
 */
public class ClassWriterTest {

    public static void main(String[] args) throws MalformedURLException, IOException {
        ClassWriter cw = new ClassWriter(0);
        
        // 类版本，访问标志以及修饰符，类全名，泛型，父类，接口
        cw.visit(V1_8, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE,"net/zhaoxuyang/demo/asm/Cw0", null, "java/lang/Object", new String[]{"net/zhaoxuyang/demo/asm/UserMapper"});
        
        // 访问标志，名字，类型，泛型，值
        cw.visitField(ACC_PUBLIC + ACC_STATIC + ACC_FINAL, "LESS", "I", null, -1).visitEnd();
        cw.visitField(ACC_PUBLIC + ACC_STATIC + ACC_FINAL, "EQUAL", "I", null, 0).visitEnd();
        cw.visitField(ACC_PUBLIC + ACC_STATIC + ACC_FINAL, "GRATER", "I", null, 1).visitEnd();
        
        // 访问标志，名字，签名，泛型，异常
        cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "compareTo", "(Ljava/lang/Object;)I", null, null).visitEnd();
        
        // 完成类定义
        cw.visitEnd();
        
        String sysRootUrl = (new File("").toURI().toURL().getPath());
        File file = new File(sysRootUrl + "net/zhaoxuyang/demo/asm/Cw0.class");
        System.out.println(file.getAbsolutePath());
        file.getParentFile().mkdirs();
        file.createNewFile();
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(cw.toByteArray());
        }
    }
}
