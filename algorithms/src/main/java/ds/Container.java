package ds;

import java.util.NoSuchElementException;

/**
 *
 * @author zhaoxuyang
 */
public interface Container{
    int size();
    
    default boolean isEmpty(){
        return size() == 0;
    }
    default void notEmptyCheck() {
        if (isEmpty()) {
            throw new NoSuchElementException("size == 0");
        }
    }
}
