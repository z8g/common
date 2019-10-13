/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ratelimit;

import static java.lang.Math.min;
import java.util.concurrent.TimeUnit;

/**
 * 平滑升温
 */
public class SmoothWarmingUp extends SmoothRateLimiter {

    private final long warmupPeriodMicros;//预热期(微妙)
    private double slope;//坡度
    private double thresholdPermits;//阈值
    private double coldFactor;//冷因子

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
        maxPermits = thresholdPermits + 2.0 * warmupPeriodMicros / (stableIntervalMicros + coldIntervalMicros);
        slope = (coldIntervalMicros - stableIntervalMicros) / (maxPermits - thresholdPermits);
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
