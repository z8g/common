package dp;

import java.util.Arrays;

/**
 * 0-1 背包问题
 *
 * <pre>
 * n个物品和1个背包，对物品i，价值为v[i]，重量为w[i]，背包容量为W，如何装入使得总价值最大:
 * - w[i]x[i]小于等于W
 * - x[i]∈{0,1}
 * - 目标函数为max(v[i]x[i])
 * - 其中i∈[1,n]
 *
 * 假如(x[1], x[2], x[3], ..., x[n])是最优解，
 * 那么(x[2], x[3], ..., x[n])则是以下问题的一个最优解：
 * - w[i]x[i] 小于等于 W - w[1]x[1]
 * - x[i]∈{0,1}
 * - 目标函数为max(v[i]x[i])
 * - 其中i∈[2,n]
 *
 * </pre>
 *
 * 时间复杂度为O(nW)
 * 缺点：要求w数组中的元素为整数；当W>2^n时，时间复杂度为O(n2^n)
 * @author zhaoxuyang
 */
public class KnapSack {

    public static void main(String[] args) {
        int[] w = {2, 2, 6, 5, 4};
        int[] v = {6, 3, 5, 4, 6};
        int W = 10;

        byte[] result = fun(w, v, W);
        System.out.println(Arrays.toString(result));
    }

    /**
     *
     * <pre>
     * 数组c[w.length+1][W+1]存放每次迭代的执行结果
     * 数组x[w.length]存放所装入的背包的物品状态
     * @初始化 c[0][j] = c[i][0] = 0
     * 
     * @递归式 c[i][j]  = c[i-1][j] j 小于 w[i] 
     *                  = max{c[i-1][j],c[i-1][j-w[i]]+v[i]} j大于等于w[i]
     * </pre>
     * @param w 重量
     * @param v 价值
     * @param W 容量
     * @return 最优解
     */
    private static byte[] fun(int[] w, int[] v, int W) {
        int row = w.length;
        int col = W;
        byte[] x = new byte[row];
        int[][] c = new int[row + 1][col + 1];

        //存放各个子问题的最优值
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (j < w[i - 1]) {
                    c[i][j] = c[i - 1][j];
                } else {
                    int tmp = c[i - 1][j - w[i - 1]] + v[i - 1];
                    c[i][j] = Math.max(c[i - 1][j], tmp);
                }
            }
        }
        
        //构造最优解
        for (int i = row, j = col; i > 0; i--) {
            if (c[i][j] > c[i - 1][j]) {
                x[i - 1] = 1;
                j -= w[i - 1];
            }
        }
        return x;
    }
}
