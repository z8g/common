package ds.impl;

import ds.util.Node;
import ds.Bag;
import java.util.Iterator;
import ds.util.ListIterator;

/**
 * 背包是一种不支持从中删除元素的集合数据类型
 *
 * @author zhaoxuyang
 * @param <T>
 */
public class LinkedBag<T> implements Iterable<T>, Bag<T> {

    private Node<T> first;
    private int size;

    public LinkedBag() {
        first = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T data) {
        Node<T> old = first;
        first = new Node<>();
        first.data = data;
        first.next = old;
        size++;
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
