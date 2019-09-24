package net.zhaoxuyang.common.current.utilities.e6;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Solver {

    final int N;
    final float[][] data;
    final CyclicBarrier barrier;

    public Solver(float[][] matrix) {
        N = matrix.length;
        data = matrix;
        barrier = new CyclicBarrier(N, () -> {
            mergeRows();
        });
    }

    public void start() {
        for (int i = 0; i < N; i++) {
            new Thread(new Worker(i)).start();
        }
        waitUtilDone();
    }

    void mergeRows() {
        System.out.println("merging");
        synchronized ("abc") {
            "abc".notify();
        }
    }

    void waitUtilDone() {
        synchronized ("abc") {
            try {
                System.out.println("main thread waiting");
                "abc".wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    class Worker implements Runnable {

        int myRow;
        boolean done = false;

        Worker(int row) {
            myRow = row;
        }

        boolean isDone() {
            return done;
        }

        void processRow(int myRow) {
            System.out.println("Processing row:" + myRow);
            for (int i = 0; i < N; i++) {
                data[myRow][i] *= 10;
            }
            done = true;
        }

        @Override
        public void run() {
            while (!isDone()) {
                processRow(myRow);

                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    System.out.println(e);
                    return;
                }
            }
        }

    }
}
