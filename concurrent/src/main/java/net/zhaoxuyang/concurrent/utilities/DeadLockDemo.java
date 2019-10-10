package net.zhaoxuyang.concurrent.utilities;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 一个死锁的例子
 *
 * @datetime 2019-03-11 03:38
 */
public class DeadLockDemo {

    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    public void deadLock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(DeadLockDemo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    synchronized (B) {
                        System.out.println("AB");
                    }
                }
            }

        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println("BA");
                    }
                }
            }
        });
        
        t1.start();t2.start();
    }
}
