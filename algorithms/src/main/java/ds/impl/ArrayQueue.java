package ds.impl;

import ds.Queue;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 能动态调整数组大小的队列
 * @author zhaoxuyang
 * @param <T>
 */
public class ArrayQueue<T> implements Iterable<T>,Queue<T> {

    private T[] array;
    private int size;
    private int first;
    private int last;

    public ArrayQueue() {
        array = (T[]) new Object[2];
        size = 0;
        first = 0;
        last = 0;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public void enqueue(T data) {
        if (size == array.length) {
            resize(2 * array.length);
        }
        array[last++] = data;
        if (last == array.length) {
            last = 0;
        }
        size++;
    }

    @Override
    public T dequeue() {
        notEmptyCheck();
        T result = array[first];
        array[first] = null;
        size--;
        first++;
        if (first == array.length) {
            first = 0;
        }
        if (size > 0 && size == array.length / 4) {
            resize(array.length / 2);
        }
        return result;
    }
    
    @Override
    public T peek(){
        notEmptyCheck();
        return array[first];
    }

    private void resize(int capacity) {
        assert capacity >= size;
        T[] tmp = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            tmp[i] = array[(first + i) % array.length];
        }
        array = tmp;
        first = 0;
        last = size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ds.util.ArrayIterator(array,size);
    }

}
