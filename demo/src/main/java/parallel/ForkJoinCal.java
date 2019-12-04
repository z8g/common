package parallel;


public class ForkJoinCal extends java.util.concurrent.RecursiveTask<Long> {

    /**
     * 需要参与计算的数组
     */
    private final long[] numbers;

    private final int start;
    private final int end;
    public static final long THRESHOLD = 1_0000;


    public ForkJoinCal(long[] numbers) {
        this.numbers = numbers;
        start = 0;
        end = numbers.length;
    }

    public ForkJoinCal(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }


    /**
     * 如果分支上的计算大小不超过THRESHOLD，则改成顺序计算
     *
     * @return
     */
    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            return computeSeq();
        }
        ForkJoinCal left = new ForkJoinCal(numbers, start, start + length / 2);
        left.fork();
        ForkJoinCal right = new ForkJoinCal(numbers, start + length / 2, end);
        right.join();
        Long rightResult = right.compute();
        Long leftResult = left.join();
        return leftResult + rightResult;
    }

    private Long computeSeq() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
