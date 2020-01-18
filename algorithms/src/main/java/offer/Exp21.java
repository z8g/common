package offer;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 *
 * @author zhaoxuyang
 */
public class Exp21 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        change(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void change(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new java.util.NoSuchElementException();
        }
        int left = 0;
        int right = arr.length - 1;
        while (right - left > 1) {
            while (arr[left] % 2 == 1) {
                left++;
            }
            while (arr[right] % 2 == 0) {
                right--;
            }
            int t = arr[left];
            arr[left] = arr[right];
            arr[right] = t;
            left++;
            right--;
        }
    }
}
