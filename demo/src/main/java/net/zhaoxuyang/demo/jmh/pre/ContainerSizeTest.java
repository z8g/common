package net.zhaoxuyang.demo.jmh.pre;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
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
public class ContainerSizeTest {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ContainerSizeTest.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    final int SIZE = 10000;

    @Benchmark
    public List<Integer> noDistributionSize() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            result.add(i);
        }
        return result;
    }

    @Benchmark
    public List<Integer> preDistributionSize() {
        List<Integer> result = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            result.add(i);
        }
        return result;
    }

    @Benchmark
    public List<Integer> linkedList() {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < SIZE; i++) {
            result.add(i);
        }
        return result;
    }
    
    
    @Benchmark
    public List<Integer> vector() {
        Vector<Integer> result = new Vector<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            result.add(i);
        }
        return result;
    }
    
    

}
