package random;

/**
 *
 * 拉斯维加斯算法
 *
 * <pre>
 * void RLV(Type x, Type &y){
 *     bool success = fasle;
 *     while(!success){
 *         success = RLV(x, y);
 *     }
 * }
 * </pre>
 *
 * @author zhaoxuyang
 */
public class LasVegas {

    public static void main(String[] args) {
        split(182);
    }
    
    static void pollard(int n) {
        int i = 1;
        int x = (int) (Math.random() * n +1);
        int y = x;
        int k = 2;
        while (true) {
            i++;
            x = (x * x - 1) % n;
            int d = gcd(y - x, n);
            if ((d > 1) && (d < n)) {
                System.out.print(d + " ");
            }
            if (i == k) {
                y = x;
                k *= 2;
            }
        }
    }

    /**
     * 整数因子分解
     */
    static void split(int n) {
        int k = (int) Math.floor(Math.sqrt(n));
        for (int i = 2; i <= k; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
