package net.zhaoxuyang.concurrent.utilities.e4;

/**
 *
 * @author zhaoxuyang
 */
public class ExceptionThread2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Thread.UncaughtExceptionHandler uceh = (Thread t, Throwable e) -> {
            System.out.println("异常:" + e + "来自：" + t);
        };
        Thread t = new Thread(() -> {
            int x = 1 / 0;
        });
        
        t.setUncaughtExceptionHandler(uceh);
        t.start();
    }

}
