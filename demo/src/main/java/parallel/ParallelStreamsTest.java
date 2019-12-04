/**
 * 在这个例子中分别对以下几种方法进行了耗时测试：
 * - 顺序for循环
 * - 顺序流
 * - 并行流
 * - 避免装箱拆箱的顺序流
 * - 避免装箱拆箱的并行流
 * <p>
 * 分别对上面各个方法运行十次，返回耗时最少的一次时间。
 * 以下是输出结果，单位为毫秒：
 * 顺序for:3
 * 顺序流:97
 * 并行流:90
 * 顺序流:4
 * 并行流:1
 */
package parallel;

import java.util.function.Function;

public class ParallelStreamsTest {

    /**
     * 接收一个函数和long作为参数，对给函数的long做10次，返回最小的一次运行时间（毫秒）
     * @param adder
     * @param n
     * @return
     */
    public static long countTime(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long end = (System.nanoTime() - start) / 1_000_000;
            if (end < fastest) {
                fastest = end;
            }
        }
        return fastest;
    }

    /**
     * 累加前一千万个数
     * @param args
     */
    public static void main(String[] args) {
        long n = 1000_0000;
        System.out.println("顺序for:" + countTime(ParallelStreams::forSum, n));
        System.out.println("顺序流:" + countTime(ParallelStreams::sequentialSum, n));
        System.out.println("并行流:" + countTime(ParallelStreams::parallelSum, n));

        /**
         * 顺序for:3
         * 顺序流:96
         * 并行流:92
         *
         * 结果让人失望，并行流面对的是装箱问题，
         * 下面使用rangedSum直接产生原始类型的long
         */
        System.out.println("顺序流:" + countTime(ParallelStreams::rangedSum, n));
        System.out.println("并行流:" + countTime(ParallelStreams::parallelRangedSum, n));

        /**
         * 顺序for:3
         * 顺序流:105
         * 并行流:92
         * 顺序流:4
         * 并行流:1
         */

    }
}
