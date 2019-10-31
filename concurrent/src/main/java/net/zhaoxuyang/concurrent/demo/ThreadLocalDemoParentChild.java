package net.zhaoxuyang.concurrent.demo;

/**
 * ThreadLocal示例
 * @author zhaoxuyang
 */
public class ThreadLocalDemoParentChild {

    private static final InheritableThreadLocal<Integer> intVal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        Runnable rP = () -> {
            intVal.set(10);
            Runnable rC = () -> {
                Thread currentThread = Thread.currentThread();
                System.out.printf("%s %d\n", currentThread.getName(), intVal.get());
            };
            new Thread(rC, "C").start();
        };
        new Thread(rP, "P").start();
    }

}
