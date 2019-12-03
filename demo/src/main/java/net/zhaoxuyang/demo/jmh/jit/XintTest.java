package net.zhaoxuyang.demo.jmh.jit;

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
public class XintTest {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(XintTest.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    int x = 1;
    int y = 2;
    
    @Benchmark
    @Fork(value=1,jvmArgsAppend = "-Xint")
    public int byteCode() {
        return x + y;
    }

    
    @Benchmark
    @Fork(value=1)
    public int machineCode() {
        return x + y;
    }
    
    @Benchmark
    @Fork(value=1)
    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public int machineCodeNotInline() {
        return x + y;
    }

}
