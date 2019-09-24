
package net.zhaoxuyang.common.current.utilities.e8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 *
 * @author zhaoxuyang
 */
public class MatrixMult2 extends RecursiveAction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Matrix aaa = new Matrix(1, 3);

        // | 1 2 3 |
        aaa.setValue(0, 0, 1);
        aaa.setValue(0, 1, 2);
        aaa.setValue(0, 2, 3);

        dump(aaa);//输出

        Matrix bbb = new Matrix(3, 2);
        bbb.setValue(0, 0, 4);
        bbb.setValue(1, 0, 5);
        bbb.setValue(2, 0, 6);
        bbb.setValue(0, 1, 7);
        bbb.setValue(1, 1, 8);
        bbb.setValue(2, 1, 9);
        dump(bbb);

        Matrix ccc = new Matrix(2, 2);

        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new MatrixMult2(aaa, bbb, ccc));
        dump(ccc);

    }

    public static void dump(Matrix m) {
        for (int i = 0; i < m.getRows(); i++) {
            for (int j = 0; j < m.getCols(); j++) {
                System.out.print(m.getValue(i, j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    protected void compute() {
        if (row == -1) {
            List<MatrixMult2> tasks = new ArrayList<>();
            for (int i = 0; i < a.getRows(); i++) {
                tasks.add(new MatrixMult2(a, b, c, i));
            }
            invokeAll(tasks);
        } else {
            multiplyRowByColumn(a, b, c, row);
        }
    }

    public static void multiplyRowByColumn(Matrix a, Matrix b, Matrix c, int row) {
        for (int j = 0; j < b.getCols(); j++) {
            for (int k = 0; k < a.getCols(); k++) {
                int n = c.getValue(row, j) + a.getValue(row, k) * b.getValue(k, j);
                c.setValue(row, j, n);
            }
        }
    }

    public MatrixMult2(Matrix a, Matrix b, Matrix c) {
        this(a, b, c, -1);
    }

    public MatrixMult2(Matrix a, Matrix b, Matrix c, int row) {
        if (a.getCols() != b.getRows()) {
            throw new IllegalArgumentException("row != col");
        }
        this.a = a;
        this.b = b;
        this.c = c;
        this.row = row;
    }

    private final Matrix a, b, c;
    private final int row;

}
