/*
 * pi/4 = 4 * arctan(1/5) - arctan(1/239)
 */
package net.zhaoxuyang.concurrent.utilities.e1;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Thread Joining
 *
 * @author zhaoxuyang
 */
public class ThreadDemo3 {

    private static final BigDecimal FOUR = BigDecimal.valueOf(4);
    private static final int roundingMode = BigDecimal.ROUND_HALF_EVEN;
    private static BigDecimal result;

    public static void main(String[] args) {
        Runnable r = () -> {
            result = computePi(500000);
        };

        Thread t = new Thread(r);
        t.start();
        try {
            t.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadDemo3.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(result);

    }

    public static BigDecimal computePi(int digits) {
        int scale = digits + 5;
        BigDecimal arctan1_5 = arctan(5, scale);
        BigDecimal arctan1_239 = arctan(239, scale);
        BigDecimal pi = arctan1_5.multiply(FOUR)
                .subtract(arctan1_239)
                .multiply(FOUR);
        return pi.setScale(digits, BigDecimal.ROUND_HALF_UP);

    }

    public static BigDecimal arctan(int inverseX, int scale) {
        BigDecimal res, numer, term;
        BigDecimal invX = BigDecimal.valueOf(inverseX);
        BigDecimal invX2 = BigDecimal.valueOf(inverseX * inverseX);
        numer = BigDecimal.ONE.divide(invX, scale, roundingMode);
        res = numer;
        int i = 1;
        do {
            numer = numer.divide(invX2, scale, roundingMode);
            int denom = 2 * i + 1;
            term = numer.divide(BigDecimal.valueOf(denom), scale, roundingMode);

            if (i % 2 != 0) {
                res = res.subtract(term);
            } else {
                res = res.add(term);
            }
            i++;
        } while (term.compareTo(BigDecimal.ZERO) != 0);
        return res;

    }
}
