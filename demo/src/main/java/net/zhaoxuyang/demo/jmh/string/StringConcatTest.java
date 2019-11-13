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


  String a = "select u.id,u.name from user  u";
  String b="  where u.id=? "   ;
  String e = " and 1=1";
  
  
  
  @Benchmark
  public String concat(){
    String c = a+b+e;
    return c ;

  }

  @Benchmark
  public String constants(){
    String c = "select u.id,u.name from user  u  where u.id=?  and 1=1";
    return c ;

  }

  @Benchmark
  public String concatbyOptimizeBuilder(){
      StringBuilder sb =new StringBuilder();
    String c = sb.append(a).append(b).append(e).toString();
    return c;
  }


  @Benchmark
  public String concatbyBuilder(){
    //不会优化
    StringBuilder sb = new StringBuilder();
    sb.append(a);
    sb.append(b);
    sb.append(e);
    return sb.toString();
  }

  @Benchmark
  public String concatbyBuffer(){
    StringBuffer sb = new StringBuffer();
    sb.append(a);
    sb.append(b);
    sb.append(e);
    return sb.toString();
  }


  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
      .include(StringConcatTest.class.getSimpleName())
      .forks(1)
      .build();
    new Runner(opt).run();
  }
}
