package util;

import java.util.Arrays;

/**
 * 设计一种公平的洗牌算法（算法导论）
 *
 * @author zhaoxuyang
 */
public class Shuffle {

    public static void main(String[] args) {
        Integer[] a = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
        };
        shuffle(a);
        System.out.println(Arrays.toString(a));
    }

    public static <T extends Comparable> void shuffle(T[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, i, rand(0, i));
        }
    }

    private static int rand(int begin, int end) {
        return (int) (begin + Math.random() * (end - begin + 1));
    }

    private static <T extends Comparable> void swap(T[] arr, int i, int j) {
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
