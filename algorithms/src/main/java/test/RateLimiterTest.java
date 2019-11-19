/**
 * QPS
 * 原理：每天80%的访问集中在20%的时间里，这20%时间叫做峰值时间。
 * 公式：( 总PV数 * 80% ) / ( 每天秒数 * 20% ) = 峰值时间每秒请求数(QPS) 。
 * 机器：峰值时间每秒QPS / 单台机器的QPS = 需要的机器 。
 * 每天300w PV 的在单台机器上，这台机器需要多少QPS？
 * ( 3000000 * 0.8 ) / (86400 * 0.2 ) = 139 (QPS)。
 * 一般需要达到139QPS，因为是峰值。
 * ————————————————
 * 版权声明：本文为CSDN博主「乘物游心0823」的原创文章，遵循 CC 4.0 BY-SA 版权协议。
 * 原文链接：https://blog.csdn.net/lpq374606827/article/details/95577256
 * 
 * https://tech.kujiale.com/ratelimiter-architecture/
 */
package test;

import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import ratelimit.RateLimiter;

public class RateLimiterTest {

    public static void main(String[] args) throws InterruptedException {

        //        //RateLimiter rateLimiter = RateLimiter.newSmoothWarmingUp(10,1,TimeUnit.MILLISECONDS,2);
            RateLimiter rateLimiter = RateLimiter.newSmoothBursty(10);
        
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        for(int i=0;i<5;i++) {
                try {
                    rateLimiter.acquire();
                    long curTime = System.currentTimeMillis();
                    System.out.println(sdf.format(curTime));
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        
        Thread.sleep(1000);
        
        for(int i=0;i<5;i++) {
            try {
                rateLimiter.acquire();
                long curTime = System.currentTimeMillis();
                System.out.println(sdf.format(curTime));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
//        for(int i=0;i<10;i++) {
//            fixedThreadPool.submit(() -> {
//                try {
//                    rateLimiter.acquire();
//                    long curTime = System.currentTimeMillis();
//                    System.out.println(sdf.format(curTime));
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            });
//        }
//        fixedThreadPool.shutdown();
//        fixedThreadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
    }

    public String stringHash(String text) {
        return String.valueOf(text.hashCode());
    }
}
