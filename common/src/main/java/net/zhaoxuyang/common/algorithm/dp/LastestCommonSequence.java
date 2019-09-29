package net.zhaoxuyang.common.algorithm.dp;

/**
 * 最长公共子序列
 *
 * @author zhaoxuyang
 */
public class LastestCommonSequence {

    public static void main(String[] args) {
        String x = "ABCBDAB";
        String y = "BDCABA";
        int m = x.length();
        int n = y.length();
        int[][] c = new int[m + 1][n + 1];
        int[][] b = new int[m + 1][n + 1];

        lscLength(x.toCharArray(), y.toCharArray(), c, b);

//        for (int i = 0; i <= x.length(); i++) {
//            for (int j = 0; j <= y.length(); j++) {
//                System.out.print(b[i][j]+" ");
//            }
//            System.out.println();
//        }
        lcs(x.length(), y.length(), x.toCharArray(), b);
    }

    /**
     * <pre>
     * ------------------------------------------------------------
     *          = 0                             i=0 || j=0
     * c[i][j]  = c[i-1][j-1]+1                 i,j>0 && x[i]=y[j]
     *          = max(c[i][j-1],c[i-1][j])      i,j>0 && x[i]!=y[j]
     *
     * b[i][j]=1 表示c[i][j]由c[i-1][j-1]+1 得到
     * b[i][j]=2 表示c[i][j]由c[i][j-1]     得到
     * b[i][j]=3 表示c[i][j]由c[i-1][j]     得到
     * ------------------------------------------------------------
     * i行j列，初始时c[i][0]=0,c[0][j]=0
     *     B D C A B A
     *   0 0 0 0 0 0 0
     * A 0
     * B 0
     * C 0
     * B 0
     * D 0
     * A 0
     * B 0
     * ------------------------------------------------------------
     * </pre>
     *
     * @param x X序列
     * @param y Y序列
     * @param c 存入最优值
     * @param b 存入最优值的来源
     */
    private static void lscLength(char[] x, char[] y, int[][] c, int[][] b) {
        for (int i = 1; i <= x.length; i++) {
            for (int j = 1; j <= y.length; j++) {
                if (x[i - 1] == y[j - 1]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = 1;
                } else if (c[i][j - 1] > c[i - 1][j]) {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = 2;
                } else {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = 3;
                }
            }
        }

    }

    /**
     * 根据记录下的信息构造最优解
     */
    private static void lcs(int i, int j, char[] x, int[][] b) {
        if (i == 0 || j == 0) {
            return;
        }
        switch (b[i][j]) {
            case 1:
                lcs(i - 1, j - 1, x, b);
                visit(x[i - 1]);
                break;
            case 2:
                lcs(i, j - 1, x, b);
                break;
            default:
                lcs(i - 1, j, x, b);
                break;
        }
    }

    /**
     * 如何处理最优解，例如打印，或者添加到StringBuilder中
     * @param c 
     */
    private static void visit(char c) {
        System.out.print(c);
    }
}
