package util;

import java.util.Arrays;

/**
 * 排序
 *
 * @author zhaoxuyang
 */
public class Sort {

    public static void main(String[] args) {
        String[] a = {
            "1", "2", "3", "a", "a1", "b2", "a0", "_"
        };
        //Sort.heapSort(a);
        //Sort.quickSort3way(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 堆排序
     *
     * @param <T>
     * @param a
     */
    public static <T extends Comparable> void heapSort(T[] a) {
        int n = a.length;
        for (int k = n / 2; k >= 1; k--) {
            sink(a, k, n);
        }
        while (n > 1) {
            swap(a, 1 - 1, (n--) - 1);
            sink(a, 1, n);
        }
    }

    private static <T extends Comparable> void sink(T[] pq, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(pq[j - 1], pq[j])) {
                j++;
            }
            if (!less(pq[k - 1], pq[j - 1])) {
                break;
            }
            swap(pq, k - 1, j - 1);
            k = j;
        }
    }

    /**
     * 快速排序:在排序前先洗牌（可以参考随机化算法-舍伍德算法）
     * <pre>
     * 快速排序的算法改进：
     * 【切换到插入排序】【三取样切分】【熵最优的排序，三向切分】
     * <pre>
     * 三取样切分
     * (1)使用子数组的一小部分元素的中位数来切分数组，这样能切分得更好，但是需要计算中位数
     * (2)人们发现将大小设为3并用大小居中的元素切分得效果最好
     * </pre>
     * </pre>
     *
     *
     * @param <T>
     * @param a
     */
    public static <T extends Comparable> void quickSort(T[] a) {
        Shuffle.shuffle(a);
        quickSort(a, 0, a.length - 1);
//        quickSortInsert(a, 0, a.length - 1);
//        quickSort3way(a, 0, a.length - 1);
    }

    /**
     * 快速排序的改进方法-小数据量转成插入排序
     * <pre>
     * (1)对于小数组，快速排序比插入排序慢；
     * (2)因为递归，快速排序的sort方法会调用自己。
     * </pre>
     *
     * @param <T>
     * @param a
     * @param low
     * @param high
     */
    public static <T extends Comparable>
            void quickSortInsert(T[] a, int low, int high) {

        int m = 65535;
        if (high <= low + m) {
            insertSort(a, low, high);
            return;
        }
        int lt = low;
        int i = low + 1;
        int gt = high;
        T v = a[low];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                swap(a, lt++, i++);
            } else if (cmp > 0) {
                swap(a, i, gt--);
            } else {
                i++;
            }
        }
        quickSort(a, low, lt - 1);
        quickSort(a, gt + 1, high);
    }

    /**
     * 快速排序的改进方法-三向切分（可以参考荷兰国旗问题）
     * <pre>
     * 对于存在大量重复元素的数组，三向切分比常规快排高效得多。
     * </pre>
     *
     * @param <T>
     * @param a
     * @param low
     * @param high
     */
    public static <T extends Comparable>
            void quickSort3way(T[] a, int low, int high) {

        if (high <= low) {
            return;
        }
        int lt = low;
        int i = low + 1;
        int gt = high;
        T v = a[low];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                swap(a, lt++, i++);
            } else if (cmp > 0) {
                swap(a, i, gt--);
            } else {
                i++;
            }
        }
        quickSort(a, low, lt - 1);
        quickSort(a, gt + 1, high);
    }

    /**
     * 常规快速排序的排序方法
     *
     * @param <T>
     * @param a
     * @param low
     * @param high
     */
    public static <T extends Comparable>
            void quickSort(T[] a, int low, int high) {
        int p;
        if (low < high) {
            p = partition(a, low, high);
            quickSort(a, low, p - 1);
            quickSort(a, p + 1, high);
        }
    }

    /**
     * 常规快速排序的划分方法
     *
     * @param <T>
     * @param a
     * @param low
     * @param high
     * @return
     */
    private static <T extends Comparable>
            int partition(T[] a, int low, int high) {
        int i = low;
        int j = high;
        T p = a[low];
        while (i < j) {
            while (i < j && (less(p, a[j]) || eq(a[j], p))) {
                j--;
            }
            if (i < j) {
                swap(a, i++, j);
            }
            while (i < j && (less(a[i], p) || eq(a[i], p))) {
                i++;
            }
            if (i < j) {
                swap(a, i, j--);
            }
        }
        return j;
    }

    /**
     * 归并排序所需的辅助数组。不将其声明为方法内的局部变量，是为了避免重复创建数组
     */
    private static Comparable[] mergeAux;

    /**
     * 自底向上的归并排序（适用于链表组织的数据）
     *
     * @param <T>
     * @param a
     */
    public static <T extends Comparable> void mergeSort2(T[] a) {
        int N = a.length;
        mergeAux = new Comparable[a.length];
        for (int i = 1; i < N; i = i + i) {
            for (int low = 0; low < N - i; low += i + i) {
                merge(a, low, low + i - 1, Math.min(low + i + i - 1, N - 1));
            }
        }
    }

    /**
     * 自顶向下的归并排序
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
        merge(a, low, middle, high);
    }

    /**
     * 归并排序的合并方法
     * <pre>
     * 该方法先将所有元素复制到辅助数组中，再归并回数组a中。
     * 在归并时进行了4个条件判断：
     * - 左半边用尽（取右半边的元素）
     * - 右半边用尽（取左半边的元素）
     * - 右半边当前元素小于左半边的当前元素（取右半边的元素）
     * - 右半边当前元素大于等于左半边的当前元素（取左半边元素）
     * </pre>
     *
     * @param <T>
     * @param a
     * @param low
     * @param middle
     * @param high
     */
    private static <T extends Comparable>
            void merge(T[] a, int low, int middle, int high) {
        int i = low;
        int j = middle + 1;
        for (int k = low; k <= high; k++) {
            mergeAux[k] = a[k];
        }
        for (int k = low; k <= high; k++) {
            if (i > middle) {
                a[k] = (T) mergeAux[j++];
            } else if (j > high) {
                a[k] = (T) mergeAux[i++];
            } else if (less(mergeAux[j], mergeAux[i])) {
                a[k] = (T) mergeAux[j++];
            } else {
                a[k] = (T) mergeAux[i++];
            }
        }
    }

    /**
     * 希尔排序
     *
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
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    swap(a, j, j - h);
                }
            }
        }
    }

    /**
     * 插入排序
     *
     * @param <T>
     * @param a
     */
    public static <T extends Comparable> void insertSort(T[] a) {
        insertSort(a, 0, a.length);
    }

    /**
     * 插入排序
     *
     * @param <T>
     * @param a
     * @param low
     * @param high
     */
    public static <T extends Comparable> void insertSort(T[] a, int low, int high) {
        for (int i = low + 1; i < high; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                swap(a, j, j - 1);
            }
        }
    }

    /**
     * 选择排序
     *
     * @param <T>
     * @param a
     */
    public static <T extends Comparable> void selectSort(T[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            swap(a, i, min);
        }
    }

    /**
     * 根据数组的两个下标交换数组中的元素
     *
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
     *
     * @param <T>
     * @param a
     * @param b
     * @return
     */
    private static <T extends Comparable> boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    /**
     * 判断a是否等于b
     *
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
     *
     * @param <T>
     * @param array
     * @return
     */
    public static <T extends Comparable> boolean isSorted(T[] array) {
        for (int i = 1; i < array.length; i++) {
            if (less(array[i], array[i - 1])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印数组
     *
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
