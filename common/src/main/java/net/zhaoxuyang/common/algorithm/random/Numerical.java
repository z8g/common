package net.zhaoxuyang.common.algorithm.random;

/**
 * 数值随机化算法
 *
 * @author zhaoxuyang
 */
public class Numerical {

    public static void main(String[] args) {
        System.out.println(calculatePI(1));
        System.out.println(calculatePI(10));
        System.out.println(calculatePI(100));
        System.out.println(calculatePI(1000));
        System.out.println(calculatePI(100000));
        System.out.println(calculatePI(1000000));
        System.out.println(calculatePI(10000000));
        System.out.println(calculatePI(100000000));
        
        
        System.out.println(calculateDefiniteIntegral(100000000));
    }

    /**
     * 计算π的值
     * @param n
     * @return 
     */
    static double calculatePI(int n) {
        double x;
        double y;
        int k = 0;
        for (int i = 1; i <= n; i++) {
            x = Math.random();
            y = Math.random();
            if ((x * x + y * y) <= 1) {
                k++;
            }
        }
        return 4.0 * k / n;
    }

    /**
     * 计算定积分(y=x^2)
     * @param n
     * @return 
     */
    static double calculateDefiniteIntegral(int n) {
        int k = 0;
        double x;
        double y;
        for (int i = 0; i <= n; i++) {
            x = Math.random();
            y = Math.random();
            double fx = 2 * x;
            if (y <= fx) {
                k++;
            }
        }
        return 1.0 * k / n;
    }

}
