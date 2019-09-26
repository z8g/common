/**
 * 在future1完成前可以做其他事
 * future1完成
 * 在future1完成后可以做其他事
 * 在future2完成前可以做其他事
 * future2完成
 * 5
 * 在future2完成后可以做其他事
 * 在future3完成前可以做其他事情
 * future3完成
 * 5
 */
package net.zhaoxuyang.common.pattern.future;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zhaoxuyang
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        FutureService<Void, Void> service = FutureService.newService();
        Future<?> future = service.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, e);
            }
            System.out.println("future1完成");

        });
        System.out.println("在future1完成前可以做其他事");
        future.get();
        System.out.println("在future1完成后可以做其他事");

        FutureService<String, Integer> service2 = FutureService.newService();
        Future<Integer> future2 = service2.submit(input -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, e);
            }
            System.out.println("future2完成");
            return input.length();
        }, "Hello");
        System.out.println("在future2完成前可以做其他事");

        System.out.println(future2.get());
        System.out.println("在future2完成后可以做其他事");

        FutureService<String, Integer> service3 = FutureService.newService();
        service3.submit(input -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, e);
            }
            System.out.println("future3完成");
            return input.length();
        }, "Hello", System.out::println);
        System.out.println("在future3完成前可以做其他事情");

    }
}
