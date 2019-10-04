package ds;

/**
 *
 * @author zhaoxuyang
 * @param <T>
 */
public interface Queue<T> extends Container {

    T peek();

    void enqueue(T data);

    T dequeue();
}
