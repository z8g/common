package net.zhaoxuyang.concurrent.utilities.e6;

import java.util.concurrent.Semaphore;

/**
 *
 * @author zhaoxuyang
 */
public final class Pool {
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
