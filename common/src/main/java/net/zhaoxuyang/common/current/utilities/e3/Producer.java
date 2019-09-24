package net.zhaoxuyang.common.current.utilities.e3;

public class Producer extends Thread {

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
