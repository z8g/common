package ds;

/**
 *
 * @author zhaoxuyang
 * @param <T>
 */
public interface Stack<T>extends Data {

    void push(T data);

    T pop();

    T peek();
}
