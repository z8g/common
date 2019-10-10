package ds.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author zhaoxuyang
 * @param <T>
 */
public class ArrayIterator<T> implements Iterator<T> {

    private int i;
    private final int size;
    private final T[] array;

    public ArrayIterator(T[] array, int size) {
        this.array = array;
        this.size = size;
    }

    @Override
    public boolean hasNext() {
        return i < size;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array[i++];
    }
}
