package net.zhaoxuyang.common.current.utilities.e6;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhaoxuyang
 */
public class DataBuffer {

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
