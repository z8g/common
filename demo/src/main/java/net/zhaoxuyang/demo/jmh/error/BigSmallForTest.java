package net.zhaoxuyang.demo.jmh.error;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 10)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Threads(1)
@Fork(1)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class BigSmallForTest {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BigSmallForTest.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    int small = 10;
    int big = 10_0000;
    
    @Benchmark
    public void bigSmall(Blackhole hole) {
        for(int i=0;i<big;i++){
            for(int j = 0;j<small;j++){
                hole.consume(j);
            }
        }
    }

    @Benchmark
    public void smallBig(Blackhole hole) {
        for(int i=0;i<small;i++){
            for(int j = 0;j<big;j++){
                hole.consume(j);
            }
        }
    }

}
