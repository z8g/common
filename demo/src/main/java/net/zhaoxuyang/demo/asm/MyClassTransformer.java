package net.zhaoxuyang.demo.asm;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 *
 * @author zhaoxuyang
 */
public class MyClassTransformer implements ClassFileTransformer {

    public static void premain(String options, Instrumentation ins){
        ins.addTransformer(new MyClassTransformer());
    }
    
    public static void main(String[] args) {
        new Business().doSomeThing();
        new Business().doSomeThing2();
    }
    @Override
    public byte[] transform(
            ClassLoader loader, String className,
            Class<?> classBeingRedefined,
            ProtectionDomain protectionDomain,
            byte[] classfileBuffer
    ) throws IllegalClassFormatException {
        System.out.println(className);
        if (!("net/zhaoxuyang/demo/asm/Business").equals(className)) {
            return null;
        }

        String name = className.replace('/', '.');
        try{
            CtClass cc = ClassPool.getDefault().get(name);
            CtMethod cm = cc.getDeclaredMethod("doSomeThing");
            cm.insertBefore("{System.out.println(\"记录日志\")}");
            return cc.toBytecode();
        } catch (NotFoundException | CannotCompileException | IOException ex) {
            System.out.println(ex);
        }
        return null;
    }

}
