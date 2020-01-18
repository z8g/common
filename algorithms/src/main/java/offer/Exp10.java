package offer;

import java.util.Arrays;

/**
 * 斐波那契数列
 *
 * @author zhaoxuyang
 */
public class Exp10 {

    public static void main(String[] args) {
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(100));

        // 年龄排序
        int[] ageArr = new int[]{25, 25, 26, 28, 22, 29, 29, 29, 30, 20, 22, 22, 25, 27};
        sortAge(ageArr);
        System.out.println(Arrays.toString(ageArr));
    }

    public static long fibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        long n1 = 0;
        long n2 = 1;
        long n3 = n2 + n1;

        for (int i = 2; i <= n; i++) {
            n3 = n2 + n1;
            n1 = n2;
            n2 = n3;
        }
        return n3;
    }

    // 年龄排序
    private static void sortAge(int[] ageArr) {
        if (ageArr == null || ageArr.length == 0) {
            return;
        }
        int[] avgCount = new int[100]; // 年龄范围，O(1)辅助空间
        for (int i = 0; i < ageArr.length; i++) {
            avgCount[ageArr[i]]++;
        }

        // O(N)时间复杂度
        for (int i = 0, j = 0; j < avgCount.length; j++) {
            for (int c = 0; c < avgCount[j]; c++) {
                ageArr[i++] = j;
            }
        }
    }
}
