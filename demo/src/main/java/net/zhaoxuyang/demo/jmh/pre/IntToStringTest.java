package net.zhaoxuyang.demo.jmh.pre;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 10)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Threads(1)
@Fork(1)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class IntToStringTest {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(IntToStringTest.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    final static int SIZE = 10_0000;
    static String[] valueCache;

    static {
        valueCache = new String[SIZE];
        for (int i = 0; i < SIZE; i++) {
            valueCache[i] = Integer.toString(i);
        }
    }

    static String int2String(int value) {
        return value < SIZE ? valueCache[value] : Integer.toString(value);
    }

    @Param({"1", "100", "10000", "1000001"})
    int value;

    @Benchmark
    public String useCache() {
        return int2String(value);
    }

    @Benchmark
    public String noCache() {
        return Integer.toString(value);
    }

    @Benchmark
    public String appendEmptyString() {
        return "" + value;
    }

}
