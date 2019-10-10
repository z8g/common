package net.zhaoxuyang.concurrent.utilities.e6;

/**
 *
 * @author zhaoxuyang
 */
public class CyclicBarrierDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float[][] matrix = new float[3][3];
        init(matrix);
        dump(matrix);
        Solver solver = new Solver(matrix);
        solver.start();
        dump(matrix);
    }

    static void init(float[][] matrix) {
        int counter = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = counter++;
            }
        }
    }

    static void dump(float[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

}
