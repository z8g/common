package net.zhaoxuyang.common.current.utilities.e7;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * @author zhaoxuyang
 */
public class Dictionary {

    public static void main(String[] args) {
        final String[] words = {
            "a",
            "b",
            "c",
            "d"
        };
        final String[] definitions = {
            "aaa",
            "bbb",
            "ccc",
            "ddd"
        };

        final Map<String, String> dictionary = new HashMap<>();
        ReadWriteLock rwl = new ReentrantReadWriteLock();
        final Lock rLock = rwl.readLock();
        final Lock wLock = rwl.writeLock();

        Runnable writer = () -> {
            for (int i = 0; i < words.length; i++) {
                wLock.lock();
                try {
                    dictionary.put(words[i], definitions[i]);
                    System.out.printf("write:[%s : %s]\n", words[i], definitions[i]);
                } finally {
                    wLock.unlock();
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        };

        ExecutorService es = Executors.newFixedThreadPool(1);
        es.submit(writer);

        Runnable reader = () -> {
            while (true) {
                rLock.lock();
                try {
                    int i = (int) (Math.random() * words.length);
                    String s = dictionary.get(words[i]);
                    System.out.println("read:" + s);
                } finally {
                    rLock.unlock();
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        };

        es = Executors.newFixedThreadPool(1);
        es.submit(reader);

    }

}
