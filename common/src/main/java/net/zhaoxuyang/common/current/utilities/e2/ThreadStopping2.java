package net.zhaoxuyang.common.current.utilities.e2;

/**
 *
 * @author zhaoxuyang
 */
public class ThreadStopping2 {

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
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("出错：" + ex);
        }
        System.out.println("停止" + t.getName());

        t.stopThread();

        System.out.println("停止" + Thread.currentThread().getName());

    }
}
