package net.zhaoxuyang.demo.asm;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import org.objectweb.asm.ClassWriter;
import static org.objectweb.asm.Opcodes.ACC_ABSTRACT;
import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_INTERFACE;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.V1_8;
import org.objectweb.asm.util.TraceClassVisitor;

/**
 * TraceClassVisitor用来查看生成的字节码对应的类是否是想要的类.
 * @author zhaoxuyang
 */
public class TraceClassVisitorTest {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        ClassWriter cw = new ClassWriter(3);
        TraceClassVisitor tv = new TraceClassVisitor(cw, new PrintWriter(System.out));
        // 类版本，访问标志以及修饰符，类全名，泛型，父类，接口
        tv.visit(V1_8, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE,"net/zhaoxuyang/demo/asm/Cw0", null, "java/lang/Object", new String[]{"net/zhaoxuyang/demo/asm/UserMapper"});
        
        // 访问标志，名字，类型，泛型，值
        tv.visitField(ACC_PUBLIC + ACC_STATIC + ACC_FINAL, "LESS", "I", null, -1).visitEnd();
        tv.visitField(ACC_PUBLIC + ACC_STATIC + ACC_FINAL, "EQUAL", "I", null, 0).visitEnd();
        tv.visitField(ACC_PUBLIC + ACC_STATIC + ACC_FINAL, "GRATER", "I", null, 1).visitEnd();
        
        // 访问标志，名字，签名，泛型，异常
        tv.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "compareTo", "(Ljava/lang/Object;)I", null, null).visitEnd();
        
        // 完成类定义
        tv.visitEnd();
    }
}
