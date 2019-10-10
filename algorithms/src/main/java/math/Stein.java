package math;


/**
 *
 * @author zhaoxuyang
 */
public class Stein {

    public static void main(String[] args) {
        System.out.println(gcd(2412122241212121212L, 2131424432543544656L));
    }

    static long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        if (a % 2 == 0 && b % 2 == 0) {
            return 2 * gcd(a >> 1, b >> 1);
        } else if (a % 2 == 0) {
            return gcd(a >> 1, b);
        } else if (b % 2 == 0) {
            return gcd(a, b >> 1);
        } else {
            return gcd(Math.abs(a - b), Math.min(a, b));
        }
    }
}
