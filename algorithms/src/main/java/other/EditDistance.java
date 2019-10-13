package other;

/**
 * 最小编辑距离
 *
 * @author zhaoxuyang
 */
public class EditDistance {

    public static void main(String[] args) {
        System.out.print(getEditDistance("interntion", "nation"));
    }

    public static int getEditDistance(String s1, String s2) {
        char[] w1 = s1.toCharArray();
        char[] w2 = s2.toCharArray();
        int m = w1.length;
        int n = w2.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (w1[i - 1] == w2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int min = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
                    dp[i][j] = 1 + min;
                }
            }
        }
        return dp[m][n];
    }

    private static int min(int insert, int delete, int update) {
        int result = insert;
        result = result > delete ? delete : result;
        result = result > update ? update : result;
        return result;
    }
    private EditDistance() {
    }

}
