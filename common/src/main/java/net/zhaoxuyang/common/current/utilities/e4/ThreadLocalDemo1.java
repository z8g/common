package net.zhaoxuyang.common.current.utilities.e4;

/**
 *
 * @author zhaoxuyang
 */
public class ThreadLocalDemo1 {

    private static volatile ThreadLocal<String> userId = new ThreadLocal<>();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Runnable r = () ->{
            String name = Thread.currentThread().getName();
            if(name.equals("A")){
                userId.set("AAA");
            }else {
                userId.set("BBB");
            }
            System.out.println(name + ":" + userId.get());
        };
        
        Thread a = new Thread(r,"A");
        Thread b = new Thread(r,"B");
        
        a.start();
        b.start();
    }
    
}
