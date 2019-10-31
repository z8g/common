package net.zhaoxuyang.concurrent.demo;

import java.util.concurrent.TimeUnit;

/**
 * 一个死锁的例子
 */
public class DeadLockDemo {

    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args) {
        deadLock();
    }
    public static void deadLock() {
        Thread t1 = new Thread(() -> {
            synchronized (A) {
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    System.err.println(ex);
                }
                synchronized (B) {
                    System.out.println("AB");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (B) {
                synchronized (A) {
                    System.out.println("BA");
                }
            }
        });
        t1.start();
        t2.start();
    }
}
