package offer;

/**
 * 打印1到最大的N数（比如N=3，则打印1到999）
 *
 * @author zhaoxuyang
 */
public class Exp17 {

    public static void main(String[] args) {
        print(30);
    }

    private static void print(int n) {
        if (n <= 0) {
            return;
        }
        char[] digits = new char[n];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = '0';
        }
        System.out.println(new String(digits));
        while (incr(digits)) {
            print(digits);
        }
    }

    private static boolean incr(char[] digits) {
        if (isMax(digits)) {
            return false;
        }
        incr(digits, digits.length - 1);
        return true;
    }

    private static void print(char[] digits) {
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] >= '0' && digits[i] <= '9') {
                System.out.print(digits[i]);
            }
        }
        System.out.println();
    }

    private static void incr(char[] digits, int i) {
        if (digits[i] == '9') {
            digits[i] = '0';
            incr(digits, i - 1);
        } else {
            digits[i]++;
        }
    }

    private static boolean isMax(char[] digits) {
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != '9') {
                return false;
            }
        }
        return true;
    }

}
