package net.zhaoxuyang.concurrent.utilities.e7;

import java.util.concurrent.locks.Lock;

public class Producer extends Thread {

    private final Lock lock;
    private final Shared s;

    Producer(Shared s) {
        this.s = s;
        lock = s.getLock();
    }

    @Override
    public void run() {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            lock.lock();
            try {
                s.setSharedChar(ch);
                System.out.println(ch + " produced by producer.");
            } finally {
                lock.unlock();
            }
        }

    }
}
