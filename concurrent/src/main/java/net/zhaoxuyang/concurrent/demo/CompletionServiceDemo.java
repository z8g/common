package net.zhaoxuyang.concurrent.demo;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * CompletionService 接口的功能是以异步的方式一边生产新的任务，一边处理已完成任务的结果.
 * 这样就可以将执行任务与处理任务分离开。CompletionService 仅有一个实现类
 * ExecutorCompletionService，需要依赖Executor对象， 其大部分实现是使用线程池 ThreadPoolExecutor实现的。
 *
 * @author zhaoxuyang
 */
public class CompletionServiceDemo {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     * @throws java.util.concurrent.ExecutionException
     */
    public static void main(String[] args)
            throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(10);
        CompletionService<BigDecimal> cs = new ExecutorCompletionService<>(es);
        cs.submit(new CalculateE(1700));
        cs.submit(new CalculateE(170));

        Future<BigDecimal> result = cs.take();
        System.out.println(result.get());
        result = cs.take();
        System.out.println(result.get());
        es.shutdown();
    }

}

class CalculateE implements Callable<BigDecimal> {

    final int lastIter;

    CalculateE(int lastIter) {
        this.lastIter = lastIter;
    }

    BigDecimal factorial(BigDecimal n) {
        if (n.equals(BigDecimal.ZERO)) {
            return BigDecimal.ONE;
        } else {
            return n.multiply(factorial(n.subtract(BigDecimal.ONE)));
        }
    }

    @Override
    public BigDecimal call() throws Exception {
        MathContext mc = new MathContext(100, RoundingMode.HALF_UP);
        BigDecimal result = BigDecimal.ZERO;
        for (int i = 0; i < lastIter; i++) {
            BigDecimal factorial = factorial(new BigDecimal(i));
            BigDecimal res = BigDecimal.ONE.divide(factorial, mc);
            result = result.add(res);
        }

        return result;
    }

}
