package ratelimit;

public class RateLimiterTest {

    public static void main(String[] args) throws InterruptedException {
        int i = 1;
        double qps = 1;
        RateLimiter rateLimiter = RateLimiter.create(qps);
        long preTime = System.nanoTime();
        while (i <= 9) {
             rateLimiter.acquire();
            long curTime = System.nanoTime();
            System.out.println(curTime + " " + (curTime - preTime)/1000000 + " " + i);
            preTime = curTime;
            i++;
        }
    }
}
