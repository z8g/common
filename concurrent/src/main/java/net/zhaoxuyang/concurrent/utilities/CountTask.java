/**
 * 步骤1 分割任务。需要一个fork类把大任务分割成子任务，直到子任务足够小。
 *
 * 步骤2 执行任务并合并结果。分割的子任务放在双端队列里，然后几个线程分别从两端取任务。 启动一个线程从队列里拿数据。
 *
 * Fork/Join 使用两个类来完成以上两件事。 (1)ForkJoinTask：提供fork()和join()操作的机制。
 * 通常不需要继承ForkJoinTask，而是继承其两个子类中的一个： - RecursiveAction：用于没有返回结果的任务 -
 * RecursiveTask：用于有返回结果的任务
 */
package net.zhaoxuyang.concurrent.utilities;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @描述 分支/合并框架的一个示例程序
 * @author Administrator
 */
public class CountTask extends RecursiveTask<Integer> {

    private static final int MIN_TASK_NUM = 4;
    private final int start;
    private final int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int size() {
        return end - start;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        /**
         * 如果任务足够小就直接计算任务
         */
        if (size() < MIN_TASK_NUM) {
            for (int  i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            /**
             * 如果任务数大于阈值，就分裂成两个子任务计算
             */
            int middle = (start + end) / 2;
            CountTask left = new CountTask(start, middle);
            CountTask right = new CountTask(middle + 1, end);
            /**
             * 执行任务
             */
            left.fork();
            right.fork();

            /**
             * 等待子任务执行完，返回结果
             */
            int leftResult = left.join();
            int rightResult = right.join();

            /**
             * 合并子任务
             */
            sum = leftResult + rightResult;
        }
        return sum;
    }

    /**
     * @param args
     * @描述 计算1+2+3+4+..+n的结果
     * @author Administrator
     */
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool(16);
        CountTask task = new CountTask(1, 1000000);
        Future<Integer> result = forkJoinPool.submit(task);
        try {
            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getMessage());
        }
        long end = System.currentTimeMillis();
        System.out.println(end-begin);
    }

}
