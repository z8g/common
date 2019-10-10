package net.zhaoxuyang.concurrent.utilities.e6;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author zhaoxuyang
 */
public class CountDownLatchDemo {

    final static int NTHREAD = 3;

    /**
     * 保证多条线程几乎同时开始工作
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final CountDownLatch startSignal = new CountDownLatch(1);
        final CountDownLatch doneSignal = new CountDownLatch(NTHREAD);

        Runnable r = () -> {
            try {
                report("entered run()");
                startSignal.await();
                report("doing worrk");
                Thread.sleep(1000);
                doneSignal.countDown();

            } catch (InterruptedException e) {
                System.out.println(e);
            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(NTHREAD);
        for (int i = 0; i < NTHREAD; i++) {
            executor.execute(r);
        }
        try {
            System.out.println("main thread doing something");
            Thread.sleep(1000);
            startSignal.countDown();

            System.out.println("main thread doing something else");
            doneSignal.await();
            executor.shutdownNow();
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    static void report(String s) {
        System.out.println(System.currentTimeMillis()
                + ": " + Thread.currentThread() + ": " + s);
    }

}
