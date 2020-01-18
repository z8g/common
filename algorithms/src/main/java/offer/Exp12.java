package offer;

/**
 * 矩阵中的路径. 设计一个函数判断在一个矩阵中是否存在一条包含某个字符串所有字符的路径。
 *
 * @author zhaoxuyang
 */
public class Exp12 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {'a', 'b', 't', 'g'},
            {'c', 'f', 'c', 's'},
            {'j', 'd', 'e', 'h'}
        };
        System.out.println(contains(matrix, "bfce"));  // true
        System.out.println(contains(matrix, "gshe"));  // true
        System.out.println(contains(matrix, "abfb"));  // false
    }

    static int index = 0;

    private static boolean contains(int[][] matrix, String s) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new java.util.NoSuchElementException();
        }
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }

        char[] chs = s.toCharArray();
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                index = 0;
                if (constains(matrix, i, j, chs, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean constains(int[][] matrix, int row, int col,
            char[] chs, boolean[][] visited) {
        if (index >= chs.length) {
            return true;
        }

        boolean hasPath = false;
        if (row >= 0 && row < matrix.length
                && col >= 0 && col < matrix[0].length
                && visited[row][col] == false
                && chs[index] == matrix[row][col]) {
            index++;
            visited[row][col] = true;

            hasPath = constains(matrix, row - 1, col, chs, visited)
                    || constains(matrix, row + 1, col, chs, visited)
                    || constains(matrix, row, col - 1, chs, visited)
                    || constains(matrix, row, col + 1, chs, visited);
            if (!hasPath) {
                index--;
                visited[row][col] = false;
            }

        }
        return hasPath;
    }
}
