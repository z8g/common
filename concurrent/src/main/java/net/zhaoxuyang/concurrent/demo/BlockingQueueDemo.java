package net.zhaoxuyang.concurrent.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 阻塞队列示例
 * @author zhaoxuyang
 */
public class BlockingQueueDemo{

    public static void main(String[] args) {
        final BlockingQueue<Character> bq = new ArrayBlockingQueue<>(26);
        final ExecutorService executor = Executors.newFixedThreadPool(2);
        Runnable producer = () -> {
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                try {
                    bq.put(ch);
                    System.out.printf("%c profuced by producer.%n", ch);
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }
        };
        executor.execute(producer);

        Runnable consumer = () -> {
            char ch = '\0';
            do {
                try {
                    ch = bq.take();
                    System.out.println(ch);
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            } while (ch != 'Z');
            executor.shutdown();
        };
        executor.execute(consumer);
    }

}
