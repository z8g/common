package ext;

import io.StdOut;
import java.util.Arrays;

/**
 * 三数之和
 *
 * @author zhaoxuyang
 */
public class ThreeSum {

    private ThreeSum() {
    }

    private static boolean containsDuplicates(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1]) {
                return true;
            }
        }
        return false;
    }

    private static void printAll(int[] a, int sum) {
        int n = a.length;
        Arrays.sort(a);
        if (containsDuplicates(a)) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int k = Arrays.binarySearch(a, sum - (a[i] + a[j]));
                if (k > j) {
                    StdOut.println(a[i] + " " + a[j] + " " + a[k]);
                }
            }
        }
    }

    public static int count(int[] a, int sum) {
        int result = 0;
        int n = a.length;
        Arrays.sort(a);
        if (containsDuplicates(a)) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int k = Arrays.binarySearch(a, sum - (a[i] + a[j]));
                if (k > j) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        printAll(a,12);
    }
}
