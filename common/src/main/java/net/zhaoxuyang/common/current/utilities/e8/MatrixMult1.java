package net.zhaoxuyang.common.current.utilities.e8;

/**
 *
 * @author zhaoxuyang
 */
public class MatrixMult1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Matrix a = new Matrix(1, 3);

        // | 1 2 3 |
        a.setValue(0, 0, 1);
        a.setValue(0, 1, 2);
        a.setValue(0, 2, 3);

        dump(a);//输出

        Matrix b = new Matrix(3, 2);
        b.setValue(0, 0, 4);
        b.setValue(1, 0, 5);
        b.setValue(2, 0, 6);
        b.setValue(0, 1, 7);
        b.setValue(1, 1, 8);
        b.setValue(2, 1, 9);
        dump(b);

        dump(multipy(a, b));

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

    public static Matrix multipy(Matrix a, Matrix b) {

        if (a.getCols() != b.getRows()) {
            throw new IllegalArgumentException("row != col");
        }

        Matrix result = new Matrix(a.getRows(), b.getCols());
        for (int i = 0; i < a.getRows(); i++) {
            for (int j = 0; j < b.getCols(); j++) {
                for (int k = 0; k < a.getCols(); k++) {
                    int n = result.getValue(i, j) + a.getValue(i, k) * b.getValue(k, j);
                    result.setValue(i, j, n);
                }
            }
        }

        return result;

    }

}
