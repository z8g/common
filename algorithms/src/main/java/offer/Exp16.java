package offer;

/**
 * 数值的整数次方
 *
 * @author zhaoxuyang
 */
public class Exp16 {

    public static void main(String[] args) {
        System.out.println(pow(12, -1));
        System.out.println(pow(12, 1));
        System.out.println(pow(12, 2));
    }

    private static double pow(int base, int n) {
        if (n < 0) {
            return 1 / pow(base, -n);
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return base;
        }
        double result = pow(base, n >> 1);
        result *= result;
        if ((n & 0x1) == 1) {
            result *= base;
        }
        return result;
    }

}
