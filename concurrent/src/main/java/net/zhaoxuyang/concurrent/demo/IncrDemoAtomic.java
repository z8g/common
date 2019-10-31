package net.zhaoxuyang.concurrent.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author zhaoxuyang
 */
public class IncrDemoAtomic {

    private static AtomicLong atomicID = new AtomicLong(1);

    static long getNextAtomicID() {
        return atomicID.getAndIncrement();
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.submit(() -> {
            while (true) {
                System.out.println("B" + getNextAtomicID());
            }
        });

    }

}
