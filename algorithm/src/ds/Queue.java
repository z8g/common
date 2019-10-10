package ds;

/**
 *
 * @author zhaoxuyang
 * @param <T>
 */
public interface Queue<T> extends Data {

    T peek();

    void enqueue(T data);

    T dequeue();
}
