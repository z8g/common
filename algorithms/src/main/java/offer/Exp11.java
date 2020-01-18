package offer;

import java.util.NoSuchElementException;

/**
 * 旋转数组(把一个数组的开始若干元素移动到末尾)的最小数字
 *
 * @author zhaoxuyang
 */
public class Exp11 {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 1, 2};
        int min = calcMin(arr);
        System.out.println(min);

        System.out.println(calcMin(new int[]{1, 1, 1, 1, 1}));
        System.out.println(calcMin(new int[]{6, 7, 1, 2, 3, 4, 5}));
        System.out.println(Math.log(1_0000_0000));
    }

    private static int calcMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new NoSuchElementException("数组为空！");
        }
        int left = 0;
        int right = arr.length - 1;
        while (left + 1 != right) {
            int middle = (left + right) >> 1;
            if (arr[left] <= arr[middle]) {
                left = middle;
            } else if (arr[middle] <= arr[right]) {
                right = middle;
            }
        }
        return arr[right];
    }

}
