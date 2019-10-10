package ds.impl;

import ds.util.Node;
import ds.Queue;
import java.util.Iterator;
import ds.util.ListIterator;

/**
 * 先进先出队列
 *
 * @author zhaoxuyang
 * @param <T>
 */
public class LinkedQueue<T> implements Iterable<T>, Queue<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    public LinkedQueue() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T peek() {
        notEmptyCheck();
        return first.data;
    }

    @Override
    public void enqueue(T data) {
        Node<T> oldLast = last;
        last = new Node<>();
        last.data = data;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    @Override
    public T dequeue() {
        notEmptyCheck();
        T result = first.data;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (T data : this) {
            s.append(data).append(' ');
        }
        return s.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(first);
    }

}
