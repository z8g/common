package offer;

/**
 * 找出数组中重复的数字
 *
 * @author zhaoxuyang
 */
public class Exp03 {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 0, 2, 5, 3};
        findO1(arr);
        findOn(arr);
    }

    //不可以改变数组
    private static void findOn(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int len = arr.length;
        int[] countArr = new int[len];
        for (int i = 0; i < len; i++) {
            countArr[arr[i]]++;
        }
        for (int i = 0; i < len; i++) {
            if (countArr[i] > 1) {
                System.out.print(i + " ");  // result
            }
        }
    }

    // 可以改变数组
    private static void findO1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            while (arr[i] != i) {
                if (arr[i] == arr[arr[i]]) {
                    System.out.print(arr[i] + " ");
                    break;
                }
                int t = arr[i];
                arr[i] = arr[t];
                arr[t] = t;
            }

        }
    }
}
