package util;

/**
 * 包含一些常见的搜索算法
 * @author zhaoxuyang
 */
public class Search {

    private Search() {
    }

    /**
     * 二分搜索
     * @param a
     * @param key
     * @return 
     */
    public static int binarySearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (key < a[middle]) {
                high = middle - 1;
            } else if (key > a[middle]) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
