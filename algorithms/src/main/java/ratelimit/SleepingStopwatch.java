package ratelimit;

import static java.util.concurrent.TimeUnit.MICROSECONDS;

/**
 * 睡眠表
 *
 * @author zhaoxuyang
 */
abstract class SleepingStopwatch {

    public static SleepingStopwatch create() {
        return new SleepingStopwatch() {
            final Stopwatch stopwatch = Stopwatch.createStarted();

            @Override
            protected long readMicros() {
                return stopwatch.elapsed(MICROSECONDS);
            }

            @Override
            protected void sleepUninterruptibly(long micros) {
                if (micros > 0) {
                    RateLimiterUtil.sleepUninterruptibly(micros, MICROSECONDS);
                }
            }
        };
    }

    protected SleepingStopwatch() {
    }

    protected abstract long readMicros();

    protected abstract void sleepUninterruptibly(long micros);

}
