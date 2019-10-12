package ratelimit;

public class RateLimiterTest {

    public static void main(String[] args) throws InterruptedException {
        int i = 1;
        double qps = 1;
        RateLimiter rateLimiter = RateLimiter.create(qps);
        while (i <= 9) {
            rateLimiter.acquire();
            System.out.println("index: " + i);
            i++;
        }
    }
}
