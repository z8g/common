package net.zhaoxuyang.concurrent.demo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zhaoxuyang
 */
public class SemaphoreDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final Pool pool = new Pool();
        Runnable r = () -> {
            String name = Thread.currentThread().getName();
            try {
                while (true) {
                    String item = pool.getItem();
                    System.out.println(name + " acquiing " + item);
                    Thread.sleep((long) (200 + Math.random() * 100));
                    System.out.println(name + " putting back " + item);
                    pool.putItem(item);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(SemaphoreDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        
        Executor[] executors = new ExecutorService[Pool.MAX_AVAILABLE+1];
        for(int i=0;i<executors.length;i++){
            executors[i]=Executors.newSingleThreadExecutor();
            executors[i].execute(r);
        }
    }
}


 class Pool {
    public static final int MAX_AVAILABLE  = 10;
    public final Semaphore available  =new Semaphore(MAX_AVAILABLE,true);
    private final String[] items;
    private final boolean[] used = new boolean[MAX_AVAILABLE];
    Pool(){
        items = new String[MAX_AVAILABLE];
        for(int i =0;i<items.length;i++){
            items[i] = "I"+i;
        }
    }
    
    String getItem() throws InterruptedException{
        available.acquire();
        return getNextAvailableItem();
    }
    void putItem(String item){
        if(markAsUnused(item)){
            available.release();
        }
    }
    
    synchronized String getNextAvailableItem(){
        for(int i =0;i<MAX_AVAILABLE;i++){
            if(!used[i]){
                used[i]=true;
                return items[i];
            }
        }
        return null;
    }
    
    private synchronized boolean markAsUnused(String item){
        for(int i=0;i<MAX_AVAILABLE;++i){
            if(item.equals(items[i])){
                if(used[i]){
                    used[i]=false;
                    return true;
                }
            }else {
                return false;
            }
        }
        return false;
    }
}
