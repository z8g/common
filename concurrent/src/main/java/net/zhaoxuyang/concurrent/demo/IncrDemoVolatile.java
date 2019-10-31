package net.zhaoxuyang.concurrent.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author zhaoxuyang
 */
public class IncrDemoVolatile {

    private static volatile long nextID = 1;

    static synchronized long getNextID() {
        return nextID++;
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.submit(() -> {
            while (true) {
                System.out.println("A" + getNextID());
            }
        });

    }

}
