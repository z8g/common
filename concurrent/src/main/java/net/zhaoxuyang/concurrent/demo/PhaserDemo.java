package net.zhaoxuyang.concurrent.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/**
 *
 * @author zhaoxuyang
 */
public class PhaserDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Runnable> tasks = new ArrayList<>();
        tasks.add(()->{
            System.out.printf("%s running at %d%n", 
                    Thread.currentThread().getName(),
                    System.currentTimeMillis());
        });
        
        tasks.add(()->{
            System.out.printf("%s running at %d%n", 
                    Thread.currentThread().getName(),
                    System.currentTimeMillis());
        });
        
        runTasks(tasks);
    }
    
    static void runTasks(List<Runnable> tasks){
        final Phaser phaser = new Phaser(1);
        for(final Runnable task:tasks){
            phaser.register();
            Runnable r  = ()->{
                try{
                    Thread.sleep((long) (50 + Math.random() * 300));
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
                phaser.arriveAndAwaitAdvance();
                
                task.run();
            };
            Executors.newSingleThreadExecutor().execute(r);
        }
        phaser.arriveAndDeregister();
        
    }
    
}
