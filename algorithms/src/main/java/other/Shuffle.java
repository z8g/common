/**
 * 设计一种公平的洗牌算法
 */
package other;

import java.util.Arrays;

/**
 *
 * @author zhaoxuyang
 */
public class Shuffle {

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            int n = rand(2,5);
            System.out.println(n);
        }
        int[] a = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
        };
        shuffle(a);
        System.out.println(Arrays.toString(a));
    }

    public static void shuffle(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr,i,rand(0, i));
        }
    }

    private static int rand(int begin, int end) {
        return (int) (begin + Math.random() * (end - begin+1));
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
