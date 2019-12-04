package refactor.observer;

/**
 * @author zhaoxuyang
 */
public interface Subject {
    void register(Observer observer);
    void notify(String text);
}
