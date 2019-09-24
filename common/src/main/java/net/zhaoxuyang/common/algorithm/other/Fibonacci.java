package net.zhaoxuyang.common.algorithm.other;

/**
 * 暴力递归，记忆搜索，矩阵求法，流处理求斐波那契数列
 * 结论：
 * （1）流处理并没有想象中的快
 * （2）暴力递归效率及其低下，N稍微大点（40左右）就已经算不出结果
 * （3）矩阵求法并没有记忆搜索快，但是在计算量较大的【别的程序】中却是最快的
 */
import java.util.stream.Stream;

/**
 *
 * @author zhaoxuyang
 */
public class Fibonacci {

    public static void main(String[] args) throws InterruptedException {
        int n = 50;
        int res;
        long start;

//        start = System.nanoTime();
//        res = f1(n);
//        System.out.println(res);
//        System.out.println(System.nanoTime() - start);

        start = System.nanoTime();
        res = f2(n);
        System.out.println(res);
        System.out.println(System.nanoTime() - start);

        start = System.nanoTime();
        res = f3(n);
        System.out.println(res);
        System.out.println(System.nanoTime() - start);

        start = System.nanoTime();
        res = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .skip(n)
                .map(t -> t[0])
                .findFirst()
                .get();
        System.out.println(res);
        System.out.println(System.nanoTime() - start);

        /*
        n=20时，输出
6765
705588
6765
21391
6765
38888
6765
72026229
        
        n=100时，注释掉O(2^N)的第一段因为要很久时间，所以后三个的输出
 -980107325
166519
-980107325
43165
-980107325
72650035
         */
    }

    /**
     * O(2^N)
     *
     * @param n
     * @return
     */
    public static int f1(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return f1(n - 1) + f1(n - 2);
        }
    }

    /**
     * 记忆搜索 O(N)
     *
     * @param n
     * @return
     */
    public static int f2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int res = 1;
        int pre = 1;
        for (int i = 3; i <= n; i++) {
            int tmp = res;
            res = res + pre;
            pre = tmp;
        }
        return res;
    }

    /**
     * 矩阵求法 O(logN)
     * <pre>
     * 如果递归式严格遵循F(N)=F(N-1)+F(N-2)，
     * 对于求第N项值，有矩阵乘法的方式可以将时间复杂度降至O(ogN)
     * 二阶递推数列，状态矩阵为2*2的矩阵：
     *
     * (F(n),F(n-1)) = (F(n-1),F(n-2)) * | a b |
     *                                   | c d |
     * 斐波那契数列的前4项代入求出状态矩阵：
     * | a b |     | 1 1 |
     * | c d |  =  | 1 0 |
     *
     * (F(n),F(n-1)) = (F(n-1), F(n-2)) * | 1 1 | = (1,1) * | 1 1 |^(n-2)
     *                                         | 1 0 |           | 1 0 |
     * 问题变成求矩阵N次方
     * 以整数10的75次方为例：
     * 75的二进制为1001011，则10的75次方=10^64 * 10^8 * 10^2 * 10^1
     * 把累乘的值相乘即可
     *
     * 对于矩阵，求矩阵m的p次方请参看matrixPower方法，其中muliMatrix是两个矩阵相乘的具体实现
     * </pre>
     *
     * @param n
     * @return
     */
    public static int f3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = matrixPower(base, n - 2);
        return res[0][0] + res[1][0];
    }

    /**
     * @param m
     * @param p
     * @return
     */
    private static int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }
        int[][] tmp = m;
        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0) {
                res = muliMatrix(res, tmp);
            }
            tmp = muliMatrix(tmp, tmp);
        }
        return res;
    }

    private static int[][] muliMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m2[0].length; i++) {
            for (int j = 0; j < m1.length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }
}
