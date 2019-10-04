package ds.impl;

import ds.util.Node;
import ds.Stack;
import java.util.Iterator;
import ds.util.ListIterator;

/**
 * 栈
 *
 * @author zhaoxuyang
 * @param <T>
 */
public class LinkedStack<T> implements Iterable<T>,Stack<T> {

    private Node<T> first;
    private int size;

    public LinkedStack() {
        first = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * 向栈中推入一个新元素
     *
     * @param data 新元素
     */
    @Override
    public void push(T data) {
        Node<T> oldFirst = first;
        first = new Node<>();
        first.data = data;
        first.next = oldFirst;
        size++;
    }

    /**
     * 从栈中弹出栈首元素
     *
     * @return 栈首元素
     */
    @Override
    public T pop() {
        notEmptyCheck();
        T result = first.data;
        first = first.next;
        size--;
        return result;
    }

    /**
     * 查看栈首元素
     * @return 栈首元素
     */
    @Override
    public T peek() {
        notEmptyCheck();
        return first.data;
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
