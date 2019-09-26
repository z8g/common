package net.zhaoxuyang.common.pattern.rwlock;

/**
 * @author zhaoxuyang
 */
public interface ReadWriteLock {
    Lock readLock();
    Lock writeLock();
    
    //正在执行写操作的线程数
    int getWritingWriters();
    
    //正在等待获取写锁的线程数
    int getWaitingWriters();
    
    //正在等待获取读锁的线程数
    int getReadingReaders();
    
    static ReadWriteLock readWriteLock(){
        return new ReadWriteLockImpl();
    }
    static ReadWriteLock readWriteLock(boolean preferWriter){
        return new ReadWriteLockImpl(preferWriter);
    }
    
}
