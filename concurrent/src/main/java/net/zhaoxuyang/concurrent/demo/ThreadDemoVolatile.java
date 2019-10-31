package net.zhaoxuyang.concurrent.demo;

/**
 * 线程示例程序 - 可见性
 * @author zhaoxuyang
 */
public class ThreadDemoVolatile {

    public static void main(String[] args) {
        class StoppableThread extends Thread {

            private volatile boolean shutdown;

            @Override
            public void run() {
                synchronized (this) {
                    while (!shutdown) {
                        System.out.println(System.nanoTime());
                    }
                }

            }

            void stopThread() {
                shutdown = true;
            }
        }

        StoppableThread t = new StoppableThread();
        t.start();

        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            System.out.println("出错：" + ex);
        }
        System.out.println("停止" + t.getName());

        t.stopThread();

        System.out.println("停止" + Thread.currentThread().getName());

    }
}
