package ds.impl;

import ds.Stack;
import java.util.Iterator;
import ds.util.ArrayIterator;

/**
 * 能动态调整数组大小的栈
 * @author zhaoxuyang
 * @param <T>
 */
public class ArrayStack<T> implements Iterable<T>,Stack<T> {

    private T[] array;
    private int size;
    
    public ArrayStack(){
        array = (T[]) new Object[2];
        size = 0;
    }
    
    
    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator(array,size);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(T data) {
        if(size == array.length){
            resize(2* array.length);
        }
        array[size++] = data;
    }

    private void resize(int capacity) {
        assert capacity >= size;
        T[] tmp = (T[]) new Object[capacity];
        System.arraycopy(array, 0, tmp, 0, size);
        array = tmp;
    }
    
    @Override
    public T pop() {
        notEmptyCheck();
        T result = array[size-1];
        array[size-1] = null;
        size--;
        if(size>0 && size == array.length/4){
            resize(array.length/2);
        }
        return result;
    }
    
    @Override
    public T peek() {
        notEmptyCheck();
        return array[size-1];
    }

}
