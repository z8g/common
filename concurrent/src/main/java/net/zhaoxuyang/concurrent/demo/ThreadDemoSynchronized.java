package net.zhaoxuyang.concurrent.demo;

/**
 * 线程示例程序 - 永不停止的线程
 * @author zhaoxuyang
 */
public class ThreadDemoSynchronized {

    public static void main(String[] args) {
        class StoppableThread extends Thread {

            private boolean shutdown;

            @Override
            public void run() {
                synchronized (this) {
                    while (!shutdown) {
                        System.out.println(System.nanoTime());
                    }
                }

            }

            synchronized void stopThread() {
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
