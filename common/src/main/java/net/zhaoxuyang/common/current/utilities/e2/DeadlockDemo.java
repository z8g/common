package net.zhaoxuyang.common.current.utilities.e2;

/**
 *
 * @author zhaoxuyang
 */
public class DeadlockDemo {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    
    public void instanceMethod1(){
        synchronized(lock1){
            synchronized(lock2){
                System.out.println("lock1->lock2");
            }
        }
    }
        
    public void instanceMethod2(){
        synchronized(lock2){
            synchronized(lock1){
                System.out.println("lock2->lock1");
            }
        }
    }
    
    public static void main(String[] args){

        final DeadlockDemo dld = new DeadlockDemo();
        System.out.println(dld);

        
        Thread t1 = new Thread(()->{
            while(true){
                dld.instanceMethod1();
            }
        });
        
        Thread t2 = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            while(true){
                dld.instanceMethod2();
            }
        });
        
        
    }
    
}
