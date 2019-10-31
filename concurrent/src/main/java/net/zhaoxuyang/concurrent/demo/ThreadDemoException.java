package net.zhaoxuyang.concurrent.demo;

/**
 * <pre>
 * Exception in thread "Thread-0" java.lang.ArithmeticException: / by zero
 * at net.zhaoxuyang.concurrent.utilities.e4.ExceptionThread1.lambda$main$0(ExceptionThread1.java:14)
 * at java.lang.Thread.run(Thread.java:748)
 * </pre>
 *
 * @author zhaoxuyang
 */
public class ThreadDemoException {

    public static void main(String[] args) {
        nativeThreadException();
        processThreadException();
    }

    private static void nativeThreadException() {
        new Thread(() -> {
            int x = 1 / 0;
        }).start();
    }

    private static void processThreadException() {
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
