package ratelimit;

import static java.lang.Math.min;
import static java.util.concurrent.TimeUnit.SECONDS;
import static ratelimit.RateLimiterUtil.saturatedAdd;

/**
 * 平滑限制器
 *
 * @author zhaoxuyang
 */
public abstract class SmoothRateLimiter extends RateLimiter {

    /**
     * 当前存储的令牌数
     */
    double storedPermits;

    /**
     * 最大存储令牌数 = maxBurstSeconds * stableIntervalMicros
     */
    double maxPermits;
    /**
     * 添加令牌时间间隔 = SECONDS.toMicros(1L) / permitsPerSecond (1秒/每秒的令牌数)
     */
    double stableIntervalMicros;

    /**
     * 下一次请求可以获取令牌的起始时间。由于RateLimiter允许预消费，上次请求预消费令牌后
     * 下次请求需要等待相应的时间到nextFreeTicketMicros时刻才可以获取令牌
     */
    private long nextStartMicros = 0L;

    SmoothRateLimiter(SleepingStopwatch stopwatch) {
        super(stopwatch);
    }

    @Override
    void doSetRate(double permitsPerSecond, long nowMicros) {
        resync(nowMicros);
        double micros = SECONDS.toMicros(1L) / permitsPerSecond;
        this.stableIntervalMicros = micros;
        doSetRate(permitsPerSecond, micros);
    }

    abstract void doSetRate(double permitsPerSecond, double stableIntervalMicros);

    abstract long storedPermitsToWaitTime(double storedPermits, double permitsToTake);

    abstract double coolDownIntervalMicros();

    @Override
    double doGetRate() {
        return SECONDS.toMicros(1L) / stableIntervalMicros;
    }

    @Override
    long queryEarliestAvailable(long nowMicros) {
        return nextStartMicros;
    }

    /**
     * 可提前预定
     *
     * @param requiredPermits
     * @param nowMicros
     * @return
     */
    @Override
    long reserveEarliestAvailable(int requiredPermits, long nowMicros) {
        resync(nowMicros);
        long returnValue = nextStartMicros;
        double storedPermitsToSpend = min(requiredPermits, storedPermits);
        double freshPermits = requiredPermits - storedPermitsToSpend;
        long waitMicros = storedPermitsToWaitTime(storedPermits, storedPermitsToSpend)
                + (long) (freshPermits * stableIntervalMicros);
        nextStartMicros = saturatedAdd(nextStartMicros, waitMicros);
        storedPermits -= storedPermitsToSpend;
        return returnValue;
    }

    /**
     * 重新同步
     *
     * @param nowMicros
     */
    void resync(long nowMicros) {
        if (nowMicros > nextStartMicros) {
            double newPermits = (nowMicros - nextStartMicros) / coolDownIntervalMicros();
            storedPermits = min(maxPermits, storedPermits + newPermits);
            nextStartMicros = nowMicros;
        }
    }

}
