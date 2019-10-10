package net.zhaoxuyang.concurrent.utilities.e3;

public class Consumer extends Thread {

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
