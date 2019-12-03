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
public class VirtualCallTest {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(VirtualCallTest.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }
    
    static int staticEcho(int x){
        return x + 2;
    }

//    @Param({"false", "true"})
//    boolean virtual;
    int x = 1;
    int count = 0;
    static int MAX = 2000;

    @Benchmark
    public int callFoo() {
        Foo foo = new Foo();
        return foo.echo(x);
    }
    
    @Benchmark
    public int callBar() {
        Foo foo = new Bar();
        return foo.echo(x);
    }
    
    @Benchmark
    public int staticCall() {
        return staticEcho(x);
    }

//    private Foo getFoo() {
//        count++;
//        return (virtual && count > MAX) ? new Bar() : new Foo();
//    }
    

}
