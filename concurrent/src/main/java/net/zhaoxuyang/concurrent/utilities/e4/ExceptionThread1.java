package net.zhaoxuyang.concurrent.utilities.e4;

/**
 *
 * @author zhaoxuyang
 */
public class ExceptionThread1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Thread (()->{
            int x = 1/0;
        }).start();
    }
    
}
