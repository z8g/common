package net.zhaoxuyang.demo.jmh.string;

/**
 *
 * @author zhaoxuyang
 */
import java.text.MessageFormat;
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
public class StringFormatTest {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(StringFormatTest.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }
    
    int cityId = 62;
    String name = "全椒";
    double value = 12.3;
    
    @Benchmark
    public String format() {
        return String.format("%d|%s|%f", cityId, name, value);
    }

    @Benchmark
    public String append() {
        return cityId + "|" + name + "|" + value;
    }

    @Benchmark
    public String messageFormat() {
        return MessageFormat.format("{0}|{1}|{2}", cityId, name, value);
    }

}
