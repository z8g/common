package net.zhaoxuyang.demo.asm;

import jdk.internal.org.objectweb.asm.util.ASMifier;

/**
 * ASMifier用来产生asm代码，当有一个类时，使用这个类读取目标类，会产生产生这个字节码所需要的asm代码。如果不知道怎么写ASM代码，可以先写Java源码，然后用这个类产生相应的代码。
 * @author zhaoxuyang
 */
public class ASMifierTest {
    public static void main(String[] args) throws Exception {
        ASMifier.main(new String[]{"net.zhaoxuyang.demo.asm.User"});
    }
}
