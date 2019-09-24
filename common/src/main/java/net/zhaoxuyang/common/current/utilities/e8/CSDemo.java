package net.zhaoxuyang.common.current.utilities.e8;

import java.math.BigDecimal;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author zhaoxuyang
 */
public class CSDemo {

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
