package net.zhaoxuyang.common.current.utilities.e4;

/**
 *
 * @author zhaoxuyang
 */
public class ThreadLocalDemo2 {

    private static final InheritableThreadLocal<Integer> intVal = new InheritableThreadLocal<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Runnable rP = () -> {
            intVal.set(10);
            Runnable rC = () -> {
                Thread currentThread = Thread.currentThread();
                System.out.printf("Thread name:%s\n", currentThread.getName(), intVal.get());
            };
            new Thread(rC, "C").start();
        };
        new Thread(rP, "P").start();
    }

}
