package ratelimit;

import static java.lang.Math.min;
import java.util.concurrent.TimeUnit;

/**
 * 平滑升温
 */
public class SmoothWarmingUp extends SmoothRateLimiter {

    private final long warmupPeriodMicros;//预热期(微秒)
    private double slope;//坡度
    private double thresholdPermits;//阈值
    private double coldFactor;//冷因子

    /**
     * 
     * @param stopwatch 睡眠表
     * @param warmupPeriod 预热时间
     * @param warmupUnit 预热时间单位
     * @param coldFactor 冷却间隔时间 = 冷因子 * 间隔时间
     */
    SmoothWarmingUp(SleepingStopwatch stopwatch, long warmupPeriod, TimeUnit warmupUnit, double coldFactor) {
        super(stopwatch);
        this.warmupPeriodMicros = warmupUnit.toMicros(warmupPeriod);
        this.coldFactor = coldFactor;
    }

    /**
     * 设置速率
     * @param qps
     * @param intervalMicros 间隔时间(微秒)
     */
    @Override
    void doSetRate(double qps, double intervalMicros) {
        double oldMaxPermits = maxPermits;
        double coldIntervalMicros = intervalMicros * coldFactor;//冷却间隔时间=冷因子*间隔时间
        thresholdPermits = 0.5 * warmupPeriodMicros / intervalMicros;
        maxPermits = thresholdPermits + 2.0 * warmupPeriodMicros / (intervalMicros + coldIntervalMicros);
        slope = (coldIntervalMicros - intervalMicros) / (maxPermits - thresholdPermits);
        if (oldMaxPermits == Double.POSITIVE_INFINITY) {
            storedPermits = 0.0;
        } else {
            storedPermits = (oldMaxPermits == 0.0)
                    ? maxPermits
                    : storedPermits * maxPermits / oldMaxPermits;
        }
    }

    /**
     * 存储等待时间许可
     *
     * @param storedPermits
     * @param permitsToTake
     * @return
     */
    @Override
    long storedPermitsToWaitTime(double storedPermits, double permitsToTake) {
        //超过临界值的可用许可证
        double above = storedPermits - thresholdPermits;
        long micros = 0;
        double tmp = permitsToTake;
        if (above > 0.0) {
            //高于阈值的令牌
            double aboveToTake = min(above, permitsToTake);
            double length = permitsToTime(above) + permitsToTime(above - aboveToTake);
            micros = (long) (aboveToTake * length / 2.0);
            tmp = permitsToTake - aboveToTake;
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
