package net.zhaoxuyang.pattern.gsq;

import java.util.LinkedList;

/**
 *
 * @author zhaoxuyang
 */
public class GuardedSuspensionQueue {
    private final LinkedList<Integer> queue =new LinkedList<>();
    
    private final int LIMIT = 100;
    public void offer(Integer data) throws InterruptedException {
        synchronized(this){
            while(queue.size() >= LIMIT){
                this.wait();
            }
            queue.addLast(data);
            this.notifyAll();
        }
    }
    
    public Integer take() throws InterruptedException{
        synchronized(this){
            while(queue.isEmpty()){
                this.wait();
            }
            this.notifyAll();
            return queue.removeFirst();
        }
    }
}
