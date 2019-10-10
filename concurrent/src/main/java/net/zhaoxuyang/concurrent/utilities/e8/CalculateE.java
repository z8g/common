/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zhaoxuyang.concurrent.utilities.e8;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.concurrent.Callable;

/**
 *
 * @author zhaoxuyang
 */
public class CalculateE implements Callable<BigDecimal>{

    final int lastIter;
    
    public CalculateE(int lastIter){
        this.lastIter = lastIter;
    }
    
    @Override
    public BigDecimal call() throws Exception {
        MathContext mc = new MathContext(100, RoundingMode.HALF_UP);
        BigDecimal result = BigDecimal.ZERO;    
        for(int i=0;i<lastIter;i++){
            BigDecimal factorial = factorial(new BigDecimal(i));
            BigDecimal res  = BigDecimal.ONE.divide(factorial,mc);
            result = result.add(res);
        }
        
        return result;
    }
    
    static BigDecimal factorial(BigDecimal n){
        if(n.equals(BigDecimal.ZERO)){
            return BigDecimal.ONE;
        }else {
            return n.multiply(factorial(n.subtract(BigDecimal.ONE)));
        }
    }
    
}
