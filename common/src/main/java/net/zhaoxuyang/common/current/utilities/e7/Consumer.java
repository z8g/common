package net.zhaoxuyang.common.current.utilities.e7;

import java.util.concurrent.locks.Lock;

public class Consumer extends Thread {

    private final Shared s;
    private final Lock lock;

    Consumer(Shared s) {
        this.s = s;
        lock = s.getLock();
    }

    @Override
    public void run() {

        char ch;
        do {
            lock.lock();
            try {
                ch = s.getSharedChar();
                System.out.println(ch + " consumed by consumer.");
            } finally {
                lock.unlock();
            }
        } while (ch != 'Z');

    }
}
