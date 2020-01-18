package offer;

/**
 * 二进制中1的个数
 *
 * @author zhaoxuyang
 */
public class Exp15 {

    public static void main(String[] args) {
        System.out.println(numOf1(6));
        System.out.println(numOf1(3));
        System.out.println(numOf1(5));
        System.out.println(numOf1(7));
        System.out.println(numOf1(-7));

        System.out.println(isPow2(8));
        System.out.println(isPow2(6));

        System.out.println(numOfChange(6,1));
        System.out.println(numOfChange(6,0));

    }

    // 二进制位中有多少个1
    private static int numOf1(int i) {
        int result = 0;
        while (i != 0) {
            i &= (i - 1);
            result++;
        }
        return result;
    }

    //判断是否为2的整数次方(只有第一位是1，其余都是0)
    private static boolean isPow2(int i) {
        return ((i - 1) & i) == 0;
    }
    
    // 需要改变m的二进制表示中多少位才能得到n
    private static int numOfChange(int m, int n){
        int x = m ^ n;
        return numOf1(x);
    }

}
