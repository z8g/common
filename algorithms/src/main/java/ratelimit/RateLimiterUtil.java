/**
 * done
 */
package ratelimit;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author zhaoxuyang
 */
public class RateLimiterUtil {

    /**
     * 饱和加法. 不同于 {@link Long#sum}
     *
     * @param a
     * @param b
     * @return
     */
    public static long saturatedAdd(long a, long b) {
        long naiveSum = a + b;
        if ((a ^ b) < 0 | (a ^ naiveSum) >= 0) {
            //如果A和B有不同的符号或A与结果有相同的符号，则没有溢出，返回和。
            return naiveSum;
        }
        //其余情况下，如果符号是负的，应该返回max，否则返回min
        //其中naiveSum>=0，oneOrZero=1，否则oneOrZero=0
        long oneOrZero = ((naiveSum >>> (Long.SIZE - 1)) ^ 1);
        return Long.MAX_VALUE + oneOrZero;
    }

    public static void checkArgument(boolean expression, Object errMsg) {
        if (!expression) {
            throw new IllegalArgumentException(String.valueOf(errMsg));
        }
    }

    /**
     * 根据睡眠时间和时间单位进行 不间断睡眠
     *
     * @param sleepTime 睡眠时间
     * @param unit 时间单位
     */
    public static void sleepUninterruptibly(long sleepTime, TimeUnit unit) {
        boolean interrupted = false;
        try {
            long remainingNanos = unit.toNanos(sleepTime);
            long end = System.nanoTime() + remainingNanos;
            while (true) {
                try {
                    TimeUnit.NANOSECONDS.sleep(remainingNanos);
                    return;
                } catch (InterruptedException e) {
                    interrupted = true;
                    remainingNanos = end - System.nanoTime();
                }
            }
        } finally {
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private RateLimiterUtil() {
    }
}
