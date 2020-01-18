package offer;

/**
 * 二维数组中的查找
 *
 * @author zhaoxuyang
 */
public class Exp04 {

    public static void main(String[] args) {
        int[][] data = {
            {1, 2, 8, 9},
            {2, 4, 9, 12},
            {4, 7, 10, 13},
            {6, 8, 11, 15}
        };
        find(data, 7);
        find(data, 14);
    }

    /**
     * 二维数组中的查找
     *
     * @param data 数组特点，下大于上，右大于左
     */
    private static void find(int[][] data, int value) {
        if (data == null || data.length == 0 || data[0].length == 0) {
            return;
        }
        int row = data.length;
        int col = data[0].length;
        int i = 0;
        int j = col - 1;

        while (i < row && j < col) {
            if (data[i][j] == value) {
                System.out.print(i + " " + j);
                return;
            } else if (data[i][j] > value) {
                j--;
            } else {
                i++;
            }
            throw new IllegalArgumentException();
        }
    }

}
