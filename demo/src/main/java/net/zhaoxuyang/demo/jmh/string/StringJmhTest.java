/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zhaoxuyang.demo.jmh.string;

/**
 *
 * @author zhaoxuyang JMH只适合细粒度的方法测试，并不适用于系统之间的链路测试！
 * JMH只适合细粒度的方法测试，并不适用于系统之间的链路测试！ JMH只适合细粒度的方法测试，并不适用于系统之间的链路测试！
 */
import java.lang.invoke.MethodHandles;
import java.util.concurrent.TimeUnit;
/*
 <dependency>
    <groupId>org.openjdk.jmh</groupId>
    <artifactId>jmh-core</artifactId>
    <version>1.19</version>
</dependency>
<dependency>
    <groupId>org.openjdk.jmh</groupId>
    <artifactId>jmh-generator-annprocess</artifactId>
    <version>1.19</version>
</dependency>
 */
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 *
 *
 * @Warmup 用来配置预热的内容 iterations：预热的次数。 time：每次预热的时间。 timeUnit：时间单位，默认是s。
 * batchSize：批处理大小，每次操作调用几次方法
 *
 * @Measurement 用来控制实际执行的内容 配置的选项与warmup一样。
 *
 *
 * @author zhaoxuyang
 */
@State(Scope.Benchmark)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS,batchSize=10)//
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS,batchSize=100)
public class StringJmhTest {

    /**
     * 表示依次传入的参数，可以被 @Benchmark 标识的方法消费。 需要在类名上加State注解
     */
//    @Param({"1", "2", "3"})
//    int aaa;

    /**
     * @BenchmarkMode主要是表示测量的纬度，有以下这些纬度可供选择： Mode.Throughput 吞吐量纬度
     * Mode.AverageTime 平均时间 Mode.SampleTime 抽样检测 Mode.SingleShotTime 检测一次调用
     * Mode.All 运用所有的检测模式
     *
     * 在方法级别指定@BenchmarkMode的时候可以一定指定多个纬度，例如：      <code>@BenchmarkMode({Mode.Throughput, Mode.AverageTime,
     * Mode.SampleTime, Mode.SingleShotTime})</code> 表示同时在多个纬度对目标方法进行测量。
     *
     *
     * @OutputTimeUnit 代表测量的单位，比如秒级别，毫秒级别，微妙级别等等。
     *
     * @State的状态值主要有以下几种： Scope.Benchmark 在所有的Benchmark的工作线程中共享变量内容。 Scope.Group
     * 同一个Group的线程可以享有同样的变量。 Scope.Thread 每个线程都享有一份变量的副本，线程之间对于变量的修改不会相互影响。
     *
     */
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testStringOpConnectVal() {//连接常量
        String test = "Hello" + "," + "World" + "!";
        use(test);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testStringVal() {//直接一个常量
        String test = "Hello,World!";
        use(test);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testStringOpConnectVar() {//连接变量
        String str1 = "Hello";
        String str2 = ",";
        String str3 = "World";
        String str4 = "!";
        String test = str1 + str2 + str3 + str4;
        use(test);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testStringOpConnectVarBadMethod() {//不好的方式连接变量
        String str1 = "Hello";
        String str2 = ",";
        String str3 = "World";
        String str4 = "!";

        String test = str1;
        test += str2;
        test += str3;
        test += str4;

        use(test);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testStringBuilderAppendChain() {//StringBuidler的append链
        StringBuilder builder = new StringBuilder();
        builder.append("Hello").append(",").append("World").append("!");
        use(builder.toString());
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testStringBuilderAppendLine() {//StringBuilder的append行
        StringBuilder builder = new StringBuilder();
        builder.append("Hello");
        builder.append(",");
        builder.append("World");
        builder.append("!");
        use(builder.toString());
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testStringBuilderAppendChar() {//append字符
        StringBuilder builder = new StringBuilder();
        builder.append("Hello").append(',').append("World").append(',');
        use(builder.toString());
    }

    /**
     * 启动方法
     *
     * @param args
     * @throws RunnerException
     */
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MethodHandles.lookup().lookupClass().getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    //不使用的语句可能会被优化掉
    private void use(String text) {
        System.out.println(text);
    }
}
