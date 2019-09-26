package net.zhaoxuyang.common.pattern.rwlock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author zhaoxuyang
 */
public class ShareData {
    private final List<Character> container = new ArrayList<>();
    private final ReadWriteLock readWriteLock = ReadWriteLock.readWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();
    private final int length;
    public ShareData(int length){
        this.length = length;
        for(int i=0;i<length;i++){
            container.add(i,'\0');
        }
    }
    public char[] read() throws InterruptedException {
        try{
            readLock.lock();
            char[] newBuffer = new char[length];
            for(int i=0;i<length;i++){
                newBuffer[i] = container.get(i);
            }
            slowly();
            return newBuffer;
        } finally{
            readLock.unlock();
        }
    }
    
    public void write(int i, char c) throws InterruptedException{
        try{
            writeLock.lock();
            this.container.add(i,c);
            slowly();
        }finally{
            writeLock.unlock();
        }
    }

    private void slowly()  {
        try{
            TimeUnit.SECONDS.sleep(1);
        } catch( InterruptedException ex){
            System.out.println(ex);
        }
    }
}
