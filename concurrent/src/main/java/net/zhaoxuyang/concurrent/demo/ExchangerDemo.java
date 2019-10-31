
package net.zhaoxuyang.concurrent.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 *
 * @author zhaoxuyang
 */
public class ExchangerDemo {

    final static Exchanger<DataBuffer> EXCHANGER = new Exchanger<>();
    final static DataBuffer INITIAL_EMPTY_BUFFER = new DataBuffer();
    final static DataBuffer INITIAL_FULL_BUFFER = new DataBuffer("I");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        class FillingLoop implements Runnable {

            int count = 0;

            @Override
            public void run() {
                DataBuffer currentBuffer = INITIAL_EMPTY_BUFFER;
                try {
                    while (true) {
                        addToBuffer(currentBuffer);
                        if (currentBuffer.isFull()) {
                            System.out.println("filling thread want to exchange");
                            currentBuffer = EXCHANGER.exchange(currentBuffer);
                            System.out.println("filling thread receives exchange");
                        }
                    }
                } catch (InterruptedException e) {
                }
            }

            void addToBuffer(DataBuffer buffer) {
                String item = "NI" + (count++);
                System.out.println("Adding:" + item);
                buffer.add(item);
            }
        }

        class EmptyingLoop implements Runnable {

            @Override
            public void run() {
                DataBuffer currentBuffer = INITIAL_FULL_BUFFER;
                try {
                    while (true) {
                        takeFromBuffer(currentBuffer);
                        if (currentBuffer.isEmpty()) {
                            System.out.println("emptying thread wants to exchange");
                            currentBuffer = EXCHANGER.exchange(currentBuffer);
                            System.out.println("emptying thread receives exchange");
                        }
                    }

                } catch (InterruptedException e) {
                }
            }

            void takeFromBuffer(DataBuffer buffer) {
                System.out.println("taking:" + buffer.remove());
            }
        }
        new Thread(new EmptyingLoop()).start();
        new Thread(new FillingLoop()).start();
    }

    
    static class DataBuffer {

    private final static int MAX_LEN = 10;
    private final List<String> items = new ArrayList<>();

    public DataBuffer(String prefix) {
        for (int i = 0; i < MAX_LEN; i++) {
            String item = prefix + i;
            System.out.printf("Adding %s%n", item);
            items.add(item);
        }
    }

    public DataBuffer() {
    }

    synchronized void add(String s) {
        if (!isFull()) {
            items.add(s);
        }
    }

    synchronized String remove() {
        return isEmpty() ? null : items.remove(0);
    }

    synchronized boolean isFull() {
        return MAX_LEN > items.size();
    }

    synchronized boolean isEmpty() {
        return 0 == items.size();
    }

}
}
