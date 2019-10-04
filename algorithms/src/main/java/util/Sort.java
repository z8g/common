package util;

/**
 *
 * @author zhaoxuyang
 */
public class Sort {

    public static <T extends Comparable> void shellSort(T[] a) {
        int len = a.length;
        int h = 1;
        while (h < len / 3) {
            h = 3 * h + 1;
        }
        for (; h >= 1; h /= 3) {
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h && lt(a[j], a[j - h]); j -= h) {
                    swap(a, j, j - h);
                }
            }
        }
    }

    public static <T extends Comparable> void insertSort(T[] a) {
        int len = a.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0 && lt(a[j], a[j - 1]); j--) {
                swap(a, j, j - 1);
            }
        }
    }

    public static <T extends Comparable> void selectSort(T[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (lt(a[j], a[min])) {
                    min = j;
                }
            }
            swap(a, i, min);
        }
    }

    private static <T extends Comparable> void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static <T extends Comparable> boolean lt(T a, T b) {
        return a.compareTo(b) < 0;
    }

    private static <T extends Comparable> boolean eq(T a, T b) {
        return a.compareTo(b) == 0;
    }

    private static <T extends Comparable> boolean gt(T a, T b) {
        return a.compareTo(b) > 0;
    }

    public static <T extends Comparable> boolean isSorted(T[] array) {
        for (int i = 1; i < array.length; i++) {
            if (lt(array[i], array[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static <T extends Comparable> void show(T[] array) {
        for (T t : array) {
            System.out.print(t + " ");
        }
        System.out.println();
    }
}
