package ds.impl;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author zhaoxuyang
 * @param <T>
 */
public class MaxPriorityQueue<T> implements Iterable<T> {

    private T[] pq;
    private int size;
    private Comparator<T> comparator;

    public MaxPriorityQueue(int capacity, Comparator comparator) {
        pq = (T[]) new Object[capacity + 1];
        size = 0;
        this.comparator = comparator;
    }

    public MaxPriorityQueue(int capacity) {
        this(capacity, null);
    }

    public MaxPriorityQueue(Comparator comparator) {
        this(1, comparator);
    }

    public MaxPriorityQueue() {
        this(1);
    }

    public MaxPriorityQueue(T[] keys) {
        size = keys.length;
        pq = (T[]) new Object[size + 1];
        System.arraycopy(keys, 0, pq, 1, size);
        for (int k = size / 2; k >= 1; k--) {
            sink(k);
        }
    }

    public void insert(T key) {
        if (size == pq.length - 1) {
            resize(2 * pq.length);
        }
        pq[++size] = key;
        swim(size);
    }

    public T max() {
        notEmptyCheck();
        return pq[1];
    }

    public T deleteMax() {
        notEmptyCheck();
        T result = pq[1];
        swap(1, size--);
        sink(1);
        pq[size + 1] = null;
        if ((size > 0) && (size == (pq.length - 1) / 4)) {
            resize(pq.length / 2);
        }
        return result;
    }

    private void notEmptyCheck() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    private boolean less(int a, int b) {
        if (comparator == null) {
            return ((Comparable<T>) pq[a]).compareTo(pq[b]) < 0;
        } else {
            return comparator.compare(pq[a], pq[b]) < 0;
        }
    }

    private void swap(int a, int b) {
        T tmp = pq[a];
        pq[a] = pq[b];
        pq[b] = tmp;
    }

    private void resize(int capacity) {
        T[] tmp = (T[]) new Object[capacity];
        for (int i = 1; i <= size; i++) {
            tmp[i] = pq[i];
        }
        pq = tmp;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private boolean isEmpty() {
        return size() == 0;
    }

    private int size() {
        return size;
    }

}
