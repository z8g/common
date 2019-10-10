package net.zhaoxuyang.concurrent.utilities.e6;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
                    String item;
                    System.out.println(name + " acquiing " + (item = pool.getItem()));
                    Thread.sleep((int) (200 + Math.random() * 100));
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
