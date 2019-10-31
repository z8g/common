package net.zhaoxuyang.concurrent.demo;

/**
 * ThreadLocal示例
 * @author zhaoxuyang
 */
public class ThreadLocalDemoName {

    private static ThreadLocal<String> userId = new ThreadLocal<>();

    public static void main(String[] args) {
        Runnable r = () -> {
            String name = Thread.currentThread().getName();
            if (name.equals("A")) {
                userId.set("AAA");
            } else {
                userId.set("BBB");
            }
            System.out.println(name + ":" + userId.get());
        };

        Thread a = new Thread(r, "A");
        Thread b = new Thread(r, "B");

        a.start();
        b.start();
    }

}
