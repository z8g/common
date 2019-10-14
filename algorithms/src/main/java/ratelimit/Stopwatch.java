/**
 * done
 */
package ratelimit;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * 以纳秒为单位的秒表
 */
public class Stopwatch {

    public static Stopwatch createUnstarted() {
        return new Stopwatch();
    }

    public static Stopwatch createStarted() {
        return new Stopwatch().start();
    }

    private static void checkState(boolean expression, Object errMsg) {
        if (!expression) {
            throw new IllegalStateException(String.valueOf(errMsg));
        }
    }

    private boolean isRunning;
    private long elapsedNanos;
    private long startNanos;

    public boolean isRunning() {
        return isRunning;
    }

    public Stopwatch start() {
        checkState(!isRunning, "Stopwatch已经运行了");
        isRunning = true;
        startNanos = System.nanoTime();
        return this;
    }

    public Stopwatch stop() {
        long tick = System.nanoTime();
        checkState(isRunning, "Stopwatch已经停止了");
        isRunning = false;
        elapsedNanos += (tick - startNanos);
        return this;
    }

    public Stopwatch reset() {
        elapsedNanos = 0;
        isRunning = false;
        return this;
    }

    /**
     * @return 计算出来的持续时间
     */
    private long elapsedNanos() {
        return isRunning
                ? System.nanoTime() - startNanos + elapsedNanos
                : elapsedNanos;
    }

    /**
     * @param timeUnit 时间单位
     * @return 此秒表上显示的当前运行时间，以所需的时间单位(向下取整)
     */
    public long elapsed(TimeUnit timeUnit) {
        return timeUnit.convert(elapsedNanos(), NANOSECONDS);
    }

    /**
     * @return 持续时间对象 {@link Duration} (不会四舍五入)
     */
    public Duration elapsed() {
        return Duration.ofNanos(elapsedNanos());
    }

    @Override
    public String toString() {
        Long nanos = elapsedNanos() / 1000_000;
        return nanos.toString();
    }

}
