package parallel;

import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author zhaoxuyang
 */
public class ParallelStreams {

    /**
     * 顺序流(内部迭代)
     *
     * @param n
     * @return
     */
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    /**
     * for循环(外部迭代)
     *
     * @param n
     * @return
     */
    public static long forSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }

    /**
     * 并行流（存在装箱问题）
     *
     * @param n
     * @return
     */
    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    /**
     * 并行流（产生原始数据类型），避免了装箱拆箱操作
     * 选择适当的数据结构往往比并行算法更重要
     */
    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(0L, Long::sum);
    }

    /**
     * 并行流（产生原始数据类型），避免了装箱拆箱操作
     * 选择适当的数据结构往往比并行算法更重要
     */
    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);
    }
}
