package offer;

/**
 * 顺时针打印矩阵
 *
 * @author zhaoxuyang
 */
public class Exp29 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        print(matrix);
    }

    private static void print(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("null");
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;

        print(matrix, row, col);

    }

    private static void print(int[][] matrix, int row, int col) {
        if (matrix == null || row <= 0 || col <= 0) {
            return;
        }
        int start = 0;
        while (col > (start << 1) && row > (start << 1)) {
            print(matrix, col, row, start);
            start++;
        }
    }

    private static void print(int[][] matrix, int col, int row, int start) {
        int endCol = col - 1 - start;
        int endRow = row - 1 - start;
        //左上角到右上角
        for (int i = start; i <= endCol; i++) {
            System.out.print(matrix[start][i] + " ");
        }
        //右上角到右下角
        if (start < endRow) {
            for (int i = start + 1; i < endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }
        }

        if (start < endCol && start > endRow) {
            for (int i = col - 1; i >= start; i--) {
                System.out.print(matrix[endRow][i] + " ");
            }
        }
        if (start < endCol && start < endRow - 1) {
            for (int i = endRow - 1; i >= start + 1; --i) {
                System.out.print(matrix[i][start] + " ");
            }
        }
    }
}
