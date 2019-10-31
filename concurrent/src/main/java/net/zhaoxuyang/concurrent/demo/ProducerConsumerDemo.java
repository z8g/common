package net.zhaoxuyang.concurrent.demo;

/**
 *
 * @author zhaoxuyang
 */
public class ProducerConsumerDemo {

    public static void main(String[] args) {
        Shared s = new Shared();
        new Producer(s).start();
        new Consumer(s).start();
    }
}

class Producer extends Thread {

    private final Shared s;

    Producer(Shared s) {
        this.s = s;
    }

    @Override
    public void run() {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            synchronized (s) {
                s.setSharedChar(ch);
                System.out.println(ch + " produced by producer.");
            }

        }
    }
}

class Consumer extends Thread {

    private final Shared s;

    Consumer(Shared s) {
        this.s = s;
    }

    @Override
    public void run() {
        char ch;
        do {
            synchronized (s) {
                ch = s.getSharedChar();
                System.out.println(ch + " consumed by consumer.");
            }
        } while (ch != 'Z');
    }
}

class Shared {

    private char c;
    private volatile boolean writeable = true;

    synchronized void setSharedChar(char c) {
        while (!writeable) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        this.c = c;
        writeable = false;
        notify();
    }

    synchronized char getSharedChar() {
        while (writeable) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        writeable = true;
        notify();
        return c;

    }
}
