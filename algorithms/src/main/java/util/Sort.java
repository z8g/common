package util;

/**
 *
 * @author zhaoxuyang
 */
public class Sort {

    //归并排序所需的辅助数组
    private static Comparable[] mergeAux;

    /**
     * 归并排序
     *
     * @param <T>
     * @param a
     */
    public static <T extends Comparable> void mergeSort(T[] a) {
        mergeAux = new Comparable[a.length];
        mergeSort(a, 0, a.length - 1);
    }

    /**
     * 自顶向下的归并排序
     *
     * @param <T>
     * @param a
     * @param low
     * @param high
     */
    public static <T extends Comparable>
            void mergeSort(T[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int middle = low + (high - low) / 2;
        mergeSort(a, low, middle);
        mergeSort(a, middle + 1, high);
        mergeMerge(a, low, middle, high);
    }

    /**
     * 合并
     * <pre>
     * 该方法先将所有元素复制到辅助数组中，再归并回数组a中。 
     * 在归并时进行了4个条件判断： 
     * - 左半边用尽（取右半边的元素）
     * - 右半边用尽（取左半边的元素） 
     * - 右半边当前元素小于左半边的当前元素（取右半边的元素） 
     * - 右半边当前元素大于等于左半边的当前元素（取左半边元素）
     * </pre>
     * @param <T>
     * @param a
     * @param low
     * @param middle
     * @param high
     */
    private static <T extends Comparable>
            void mergeMerge(T[] a, int low, int middle, int high) {
        int i = low;
        int j = middle + 1;
        for (int k = low; k <= high; k++) {
            mergeAux[k] = a[k];
        }
        for (int k = low; k <= high; k++) {
            if (j > middle) {
                a[k] = (T) mergeAux[j++];
            } else if (j > high) {
                a[k] = (T) mergeAux[i++];
            } else if (lt(mergeAux[j], mergeAux[i])) {
                a[k] = (T) mergeAux[j++];
            } else {
                a[k] = (T) mergeAux[i++];
            }
        }
    }

    /**
     * 希尔排序
     * @param <T>
     * @param a
     */
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
    /**
     * 插入排序
     * @param <T>
     * @param a 
     */
    public static <T extends Comparable> void insertSort(T[] a) {
        int len = a.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0 && lt(a[j], a[j - 1]); j--) {
                swap(a, j, j - 1);
            }
        }
    }
    /**
     * 选择排序
     * @param <T>
     * @param a 
     */
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

    /**
     * 根据数组的两个下标交换数组中的元素
     * @param <T>
     * @param array
     * @param i
     * @param j 
     */
    private static <T extends Comparable> void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * 判断a是否小于b
     * @param <T>
     * @param a
     * @param b
     * @return 
     */
    private static <T extends Comparable> boolean lt(T a, T b) {
        return a.compareTo(b) < 0;
    }

    /**
     * 判断a是否等于b
     * @param <T>
     * @param a
     * @param b
     * @return 
     */
    private static <T extends Comparable> boolean eq(T a, T b) {
        return a.compareTo(b) == 0;
    }

    /**
     * 判断数组是否排序
     * @param <T>
     * @param array
     * @return 
     */
    public static <T extends Comparable> boolean isSorted(T[] array) {
        for (int i = 1; i < array.length; i++) {
            if (lt(array[i], array[i - 1])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印数组
     * @param <T>
     * @param array 
     */
    public static <T extends Comparable> void print(T[] array) {
        for (T t : array) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

}
