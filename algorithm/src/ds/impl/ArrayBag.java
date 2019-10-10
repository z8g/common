package ds.impl;

import ds.Bag;
import java.util.Iterator;
import ds.util.ArrayIterator;

/**
 * 能动态调整数组大小的背包
 *
 * @author zhaoxuyang
 * @param <T>
 */
public class ArrayBag<T> implements Iterable<T>,Bag<T> {

    private T[] array;
    private int size;

    public ArrayBag() {
        array = (T[]) new Object[2];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T data) {
        if (size == array.length) {
            resize(2 * array.length);
        }
        array[size++] = data;
    }
    private void resize(int capacity) {
        assert capacity >= 0;
        T[] tmp = (T[]) new Object[capacity];
        System.arraycopy(array, 0, tmp, 0, size);
        array = tmp;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator(array,size);
    }
    

}
