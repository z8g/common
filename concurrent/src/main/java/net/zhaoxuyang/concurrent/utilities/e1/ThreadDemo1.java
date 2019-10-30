package net.zhaoxuyang.concurrent.utilities.e1;

import java.util.concurrent.TimeUnit;
/**
 * 线程示例程序 - 线程状态
 * @author zhaoxuyang
 */
public class ThreadDemo1 {

    public static void main(String[] args) {
        boolean isDaemon = args.length != 0;
        Runnable r = () -> {
            Thread t = Thread.currentThread();
            while (true) {
                System.out.printf("%s is %salive and in %s state%n",
                        t.getName(), t.isAlive() ? "" : "not ", t.getState());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ex) {
                }
            }
        };

        Thread t1 = new Thread(r, "t1");
        if (isDaemon) {
            t1.setDaemon(true);
        }
        System.out.printf("%s is %salive and in %s state%n",
                t1.getName(), t1.isAlive() ? "" : "not ", t1.getState());
        Thread t2 = new Thread(r, "t2");
        if (isDaemon) {
            t2.setDaemon(true);
        }
        System.out.printf("%s is %salive and in %s state%n",
                t2.getName(), t2.isAlive() ? "" : "not ", t2.getState());
        
        System.out.println("========================");
        t1.start();
        t2.start();
    }
}
