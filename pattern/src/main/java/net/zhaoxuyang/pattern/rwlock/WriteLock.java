package net.zhaoxuyang.pattern.rwlock;

/**
 *
 * @author zhaoxuyang
 */
public class WriteLock implements Lock {

    private final ReadWriteLockImpl lock;

    public WriteLock(ReadWriteLockImpl readWriteLock) {
        this.lock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {
        synchronized (lock.getMutex()) {
            try {
                lock.incrementWaitingWriters();
                while (lockCheck()) {
                    lock.getMutex().wait();
                }
            } finally {
                lock.decrementWaitingWriters();
            }
            lock.incrementWritingWriters();
        }
    }

    private boolean lockCheck() {
        return (lock.getReadingReaders() > 0) || (lock.getWritingWriters() > 0);
    }

    @Override
    public void unlock() {
        synchronized (lock.getMutex()) {
            lock.decrementWritingWriters();
            lock.setPreferWriter(false);
            lock.getMutex().notifyAll();
        }
    }

}
