package net.zhaoxuyang.pattern.rwlock;

/**
 *
 * @author zhaoxuyang
 */
public class ReadLock implements Lock {

    private final ReadWriteLockImpl lock;

    public ReadLock(ReadWriteLockImpl readWriteLock) {
        this.lock = readWriteLock;
    }

    /**
     * <pre>
     * 如果此时有线程在进行写操作，或者有写线程在等待并且偏向写锁的标识为true时，
     * 就会无法获得锁，从而被挂起
     * </pre>
     *
     * @throws InterruptedException
     */
    @Override
    public void lock() throws InterruptedException {
        synchronized (lock.getMutex()) {
            while (lockCheck()) {
                lock.getMutex().wait();
            }
            lock.incrementReadingReaders();
        }
    }

    private boolean lockCheck() {
        return (lock.getWritingWriters()> 0)
                || (lock.getPreferWriter() && lock.getWaitingWriters() > 0);
    }

    /**
     * 释放锁的过程就是使得当前reading的数量减一
     * 将preferWriter设置为true，使得writer线程获得更多的机会
     * 通知唤醒与Mutex关联monitor waitset中的线程
     */
    @Override
    public void unlock() {
        synchronized(lock.getMutex()){
            lock.decrementReadingReaders();
            lock.setPreferWriter(true);
            lock.getMutex().notifyAll();
        }
    }

}
