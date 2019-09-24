package net.zhaoxuyang.common.current.utilities.e5;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author zhaoxuyang
 */
public class ExecutorServiceDemo {

    final static int LASTIFER = 17;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Callable<BigDecimal> callable = () -> {

            MathContext mc = new MathContext(100, RoundingMode.HALF_UP);

            BigDecimal result = BigDecimal.ZERO;
            for (int i = 0; i < LASTIFER; i++) {
                BigDecimal factorial = factorial(new BigDecimal(i));
                BigDecimal res = BigDecimal.ONE.divide(factorial,mc);
                result = result.add(res);
            }
            return result;
        };
        
        
        Future<BigDecimal> taskFuture = executorService.submit(callable);
        
        try{
            while(!taskFuture.isDone()){
                System.out.println("...");
            }
            System.out.println(taskFuture.get());
        }catch(InterruptedException | ExecutionException e){
            System.out.println(e);
        }
    }

    public static BigDecimal factorial(BigDecimal n) {
        if (n.equals(BigDecimal.ZERO)) {
            return BigDecimal.ONE;
        }else {
            return n.multiply(factorial(n.subtract(BigDecimal.ONE)));
        }
    }

}
