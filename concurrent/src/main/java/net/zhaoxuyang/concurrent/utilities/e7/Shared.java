package net.zhaoxuyang.concurrent.utilities.e7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Shared {

        private char c;

        private volatile boolean available;
        private final Lock lock;
        
        private final Condition condition;
        
        Shared(){
            available = false;
            lock = new ReentrantLock();
            condition = lock.newCondition();
        }
        
        Lock getLock(){
            return lock;
        }
        
        void setSharedChar(char c) {
            lock.lock();
            try{
                while(available){
                    try{
                        condition.await();
                    } catch(InterruptedException e){
                        System.out.println(e);
                    }
                    this.c = c;
                    available = true;
                    condition.signal();
                }
            }finally{
                lock.unlock();
            }
        }
        char getSharedChar() {
            lock.lock();
            try{
                while (!available) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            available = false;
            condition.signal();
            }finally{
                lock.unlock();
            }
            return c;
        }
    }