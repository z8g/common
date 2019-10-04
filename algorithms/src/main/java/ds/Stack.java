package ds;

/**
 *
 * @author zhaoxuyang
 * @param <T>
 */
public interface Stack<T>extends Container {

    void push(T data);

    T pop();

    T peek();
}
