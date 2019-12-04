package parallel;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

public class ForkJoinCalTest {

    public static long forkJoinSum(int n){
        long[] numbers = LongStream.rangeClosed(1,n).toArray();
        ForkJoinCal cal = new ForkJoinCal(numbers);
        return new ForkJoinPool().invoke(cal);
    }
    public static void main(String[] args) {
        System.out.println(forkJoinSum(100000));
    }
}
