package ds.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author zhaoxuyang
 * @param <T>
 */
public class ListIterator<T> implements Iterator<T> {

    private Node<T> current;

    public ListIterator(Node<T> first) {
        current = first;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T result = current.data;
        current = current.next;
        return result;
    }
}
