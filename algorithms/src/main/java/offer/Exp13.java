package offer;

/**
 * 机器人的运动范围(回溯)
 *
 * @author zhaoxuyang
 */
public class Exp13 {

    public static void main(String[] args) {
        System.out.println(solution(1, 1, 1));
        System.out.println(solution(1, 1, 2));
        System.out.println(solution(2, 2, 1));
        System.out.println(solution(35, 37, 18));
        System.out.println(solution(35, 38, 18));
    }

    private static int solution(int m, int n, int k) {
        if (m <= 0 || n <= 0 || k <= 0) {
            throw new IllegalArgumentException();
        }
        boolean[][] visited = new boolean[m][n];
        int count = move(m, n, k, 0, 0, visited);
        return count;
    }

    private static int move(int m, int n, int k, int row, int col, boolean[][] visited) {
        int count = 0;
        if (check(m, n, k, row, col, visited)) {
            visited[row][col] = true;
            count = 1
                    + move(m, n, k, row - 1, col, visited)
                    + move(m, n, k, row + 1, col, visited)
                    + move(m, n, k, row, col - 1, visited)
                    + move(m, n, k, row, col + 1, visited);
        }
        return count;

    }

    private static boolean check(int m, int n, int k, int row, int col, boolean[][] visited) {
        return (row >= 0 && row < m) && (col >= 0 && col < n)
                && (visited[row][col] == false)
                && (sumDigit(row) + sumDigit(col) <= k);
    }

    private static int sumDigit(final int digit) {
        int sum = 0;
        int num = digit;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
