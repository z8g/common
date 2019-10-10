package net.zhaoxuyang.pattern.rwlock;

/**
 *
 * @author zhaoxuyang
 */
public interface Lock {
    void lock() throws InterruptedException;
    void unlock();
}
