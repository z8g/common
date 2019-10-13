package ratelimit;

/**
 * 平滑突发
 *
 * @author zhaoxuyang
 */
public class SmoothBursty extends SmoothRateLimiter {

    /**
     * 在RateLimiter未使用时，最多存储几秒的令牌
     */
    final double maxBurstSeconds;

    /**
     * @param stopwatch guava中的一个时钟类实例，会通过这个来计算时间及令牌
     * @param maxBurstSeconds 在ReteLimiter未使用时，最多保存几秒的令牌，默认是1
     */
    SmoothBursty(SleepingStopwatch stopwatch, double maxBurstSeconds) {
        super(stopwatch);
        this.maxBurstSeconds = maxBurstSeconds;
    }

    @Override
    void doSetRate(double permitsPerSecond, double stableIntervalMicros) {
        double oldMaxPermits = this.maxPermits;
        maxPermits = maxBurstSeconds * permitsPerSecond;
        if (oldMaxPermits == Double.POSITIVE_INFINITY) {
            storedPermits = maxPermits;
        } else {
            storedPermits = (oldMaxPermits == 0.0)
                    ? 0.0
                    : storedPermits * maxPermits / oldMaxPermits;
        }
    }

    @Override
    long storedPermitsToWaitTime(double storedPermits, double permitsToTake) {
        return 0L;
    }

    @Override
    double coolDownIntervalMicros() {
        return stableIntervalMicros;
    }
}
