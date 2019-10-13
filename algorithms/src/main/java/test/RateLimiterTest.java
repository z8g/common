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
 */
package test;

import ratelimit.RateLimiter;

public class RateLimiterTest {

    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("1".hashCode());
        System.out.println("12".hashCode());
        System.out.println("13".hashCode());
        System.out.println("141".hashCode());
        System.out.println("我".hashCode());
        
        System.out.println(String.valueOf("我".hashCode()));
        
        int i = 1;
        double qps = 2;
        RateLimiter rateLimiter = RateLimiter.create(qps);
        long preTime = System.nanoTime();

        while (i <= 300) {
            rateLimiter.acquire();
            if (i < 8) {
                Thread.sleep(1000);
            } 
            if(i>50){
                rateLimiter.setRate(5);
            }
            long curTime = System.nanoTime();
            System.out.println(
                    String.format("curTime:%s\tElapsed:%s\tdata:%s\t%s",
                            curTime, (curTime - preTime) / 1000000, i, rateLimiter));
            preTime = curTime;
            i++;
        }
    }
    
    public String stringHash(String text){
        return String.valueOf(text.hashCode());
    }
}
