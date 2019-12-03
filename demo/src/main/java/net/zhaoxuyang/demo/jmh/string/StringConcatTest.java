package net.zhaoxuyang.demo.jmh.string;

/**
 *
 * @author zhaoxuyang
 */
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
public class StringConcatTest {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(StringConcatTest.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    String a = "select name";
    String b = "from city";
    String c = "where id=? ";

    @Benchmark
    public String concat() {
        String result = a + b + c;
        return result;

    }

    @Benchmark
    public String constants() {
        String result = "select name from city where id=?";
        return result;
    }

    @Benchmark
    public String concatbyOptimizeBuilder() {
        StringBuilder sb = new StringBuilder();
        String result = sb.append(a).append(b).append(c).toString();
        return result;
    }

    @Benchmark
    public String concatbyOptimizeBuffer() {
        StringBuffer sb = new StringBuffer();
        String result = sb.append(a).append(b).append(c).toString();
        return result;
    }

    @Benchmark
    public String concatbyBuilder() {
        // JIT不会优化
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(b);
        sb.append(c);
        String result = sb.toString();
        return result;
    }

    @Benchmark
    public String concatbyBuffer() {
        // JIT不会优化
        StringBuffer sb = new StringBuffer();
        sb.append(a);
        sb.append(b);
        sb.append(c);
        String result = sb.toString();
        return result;
    }

}
