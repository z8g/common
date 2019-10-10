package random;

/**
 * 
 * 蒙特卡罗算法
 * <pre>
 * 设p是一个实数，且 0.5 小于 p 小于 1， 
 * 如果蒙特卡罗算法对于问题的任一实例得到的正确解的概率不小于p，则称该算法是正确的。
 * </pre>
 * @author zhaoxuyang
 */
public class MonteCarlo {

    public static void main(String[] args) {
        //int[] array = {1, 2, 1};
//                System.out.println(majority(array, array.length, 0.99));
//        System.out.println(majority(array, array.length, 0.99));
        System.out.println(checkPrimeByWilson(5));
        System.out.println(checkPrimeByWilson(6));
        while(true){
            System.out.println(checkPrimeByMoteCarlo(97));

}
        
    }

    /**
     * 判断一个数组是否存在主元素 一个含有n个元素的数组，当存在一个元素占比大于n/2时，称该元素是数组的主元素。
     */
    static boolean majority(int[] array, double n, double p) {
        int k = (int) Math.ceil(Math.log(n) / Math.log(1 - 0.9));
        for (int i = 1; i <= k; i++) {
            if (checkMajority(array, n)) {
                System.out.println(array[i]);
                return true;
            }
        }
        return false;
    }

    static boolean checkMajority(int[] array, double n) {
        int randomIndex = (int) (Math.random() * n);
        int item = array[randomIndex];
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (item == array[i]) {
                k++;
            }
        }
        return (k > 1.0 * n / 2);
    }

    /**
     * 常规的判断一个数是否为素数
     *
     * @param n
     * @return
     */
    boolean checkPrime(long n) {
        int m = (int) Math.floor(Math.sqrt(n));
        for (int i = 2; i <= m; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 
     * <pre>
     * Wilson定理有很高的理论价值，定义为：对于给定的正整数n，判定n是素数的充要条件是：
     * (n-1)! === -1(mod n)
     * 例如n = 5,6,7
     * (5-1)!=24,       24 mod 5    = -1(mod 5)，故5是素数
     * (6-1)!=120,      120 mod 6   = 0(mod 6)，故6不是素数
     * (7-1)!=720,      720 mod 7   = -1(mod 7)，故6不是素数
     * 
     * </pre>
     * @param n
     * @return 
     */
    static boolean checkPrimeByWilson(long n) {
        return fan(n - 1) % n == n - 1;
    }

    static long fan(long n) {
        return n == 0 ? 1 : n * fan(n - 1);
    }
    
    static boolean checkPrimeByMoteCarlo(int n){
        int m = (int) Math.floor(Math.sqrt(n));
       
        int min = 2;
        int max = m - 1;
        int i = (int)(Math.random()*(max-min+1)+min);
        System.out.println(i);
        return n % i != 0;
    }
}
