package ratelimit;

import static java.lang.Math.min;
import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.SECONDS;
import static ratelimit.RateLimiterUtil.saturatedAdd;

/**
 * 平滑限制器
 *
 * @author zhaoxuyang
 */
abstract class SmoothRateLimiter extends RateLimiter {


    /**
     * 当前存储的令牌数
     */
    double storedPermits;

    /**
     * 最大存储令牌数 = maxBurstSeconds * stableIntervalMicros
     */
    double maxPermits;
    /**
     * 添加令牌时间间隔 = SECONDS.toMicros(1L) / permitsPerSecond；(1秒/每秒的令牌数)
     */
    double stableIntervalMicros;

    /**
     * 下一次请求可以获取令牌的起始时间。由于RateLimiter允许预消费，上次请求预消费令牌后
     * 下次请求需要等待相应的时间到nextFreeTicketMicros时刻才可以获取令牌
     */
    private long nextFreeTicketMicros = 0L;

    private SmoothRateLimiter(SleepingStopwatch stopwatch) {
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
        return nextFreeTicketMicros;
    }

    @Override
    long reserveEarliestAvailable(int requiredPermits, long nowMicros) {
        resync(nowMicros);
        long returnValue = nextFreeTicketMicros;
        double storedPermitsToSpend = min(requiredPermits, this.storedPermits);
        double freshPermits = requiredPermits - storedPermitsToSpend;
        long waitMicros
                = storedPermitsToWaitTime(this.storedPermits, storedPermitsToSpend)
                + (long) (freshPermits * stableIntervalMicros);

        this.nextFreeTicketMicros = saturatedAdd(nextFreeTicketMicros, waitMicros);
        this.storedPermits -= storedPermitsToSpend;
        return returnValue;
    }

    void resync(long nowMicros) {
        if (nowMicros > nextFreeTicketMicros) {
            double newPermits = (nowMicros - nextFreeTicketMicros) / coolDownIntervalMicros();
            storedPermits = min(maxPermits, storedPermits + newPermits);
            nextFreeTicketMicros = nowMicros;
        }
    }

    /**
     * 平滑升温
     */
    static class SmoothWarmingUp extends SmoothRateLimiter {

        private final long warmupPeriodMicros;
        private double slope;
        private double thresholdPermits;
        private double coldFactor;

        SmoothWarmingUp(SleepingStopwatch stopwatch, long warmupPeriod, TimeUnit timeUnit, double coldFactor) {
            super(stopwatch);
            this.warmupPeriodMicros = timeUnit.toMicros(warmupPeriod);
            this.coldFactor = coldFactor;
        }

        @Override
        void doSetRate(double permitsPerSecond, double stableIntervalMicros) {
            double oldMaxPermits = maxPermits;
            double coldIntervalMicros = stableIntervalMicros * coldFactor;
            thresholdPermits = 0.5 * warmupPeriodMicros / stableIntervalMicros;
            maxPermits
                    = thresholdPermits + 2.0 * warmupPeriodMicros / (stableIntervalMicros + coldIntervalMicros);
            slope = (coldIntervalMicros - stableIntervalMicros) / (maxPermits - thresholdPermits);
            if (oldMaxPermits == Double.POSITIVE_INFINITY) {
                storedPermits = 0.0;
            } else {
                storedPermits
                        = (oldMaxPermits == 0.0)
                                ? maxPermits
                                : storedPermits * maxPermits / oldMaxPermits;
            }
        }

        @Override
        long storedPermitsToWaitTime(double storedPermits, double permitsToTake) {
            double availablePermitsAboveThreshold = storedPermits - thresholdPermits;
            long micros = 0;
            double tmp = permitsToTake;
            if (availablePermitsAboveThreshold > 0.0) {
                double permitsAboveThresholdToTake = min(availablePermitsAboveThreshold, permitsToTake);
                double length = permitsToTime(availablePermitsAboveThreshold)
                        + permitsToTime(availablePermitsAboveThreshold - permitsAboveThresholdToTake);
                micros = (long) (permitsAboveThresholdToTake * length / 2.0);
                tmp = permitsToTake - permitsAboveThresholdToTake;
            }
            micros += (stableIntervalMicros * tmp);
            return micros;
        }

        private double permitsToTime(double permits) {
            return stableIntervalMicros + permits * slope;
        }

        @Override
        double coolDownIntervalMicros() {
            return warmupPeriodMicros / maxPermits;
        }
    }

    /**
     * 平滑突发
     */
    static class SmoothBursty extends SmoothRateLimiter {

        final double maxBurstSeconds;//在RateLimiter未使用时，最多存储几秒的令牌

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

}
