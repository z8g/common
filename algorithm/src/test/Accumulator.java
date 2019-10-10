package test;


import io.StdOut;
import io.StdIn;



/******************************************************************************
 *  Compilation:  javac Accumulator.java
 *  Execution:    java Accumulator < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *
 *  Mutable data type that calculates the mean, sample standard
 *  deviation, and sample variance of a stream of real numbers
 *  use a stable, one-pass algorithm.
 *
 ******************************************************************************/




/**
 * 一种能累加的数据类型
 *  The {@code Accumulator} class is a data type for computing the running
 *  mean, sample standard deviation, and sample variance of a stream of real
 *  numbers. It provides an example of a mutable data type and a streaming
 *  algorithm.
 *  <p>
 *  This implementation uses a one-pass algorithm that is less susceptible
 *  to floating-point roundoff error than the more straightforward
 *  implementation based on saving the sum of the squares of the numbers.
 *  This technique is due to
 *  <a href = "https://en.wikipedia.org/wiki/Algorithms_for_calculating_variance#Online_algorithm">B. P. Welford</a>.
 *  Each operation takes constant time in the worst case.
 *  The amount of memory is constant - the data values are not stored.
 *  <p>
 *  For additional documentation, 
 *  see <a href="https://algs4.cs.princeton.edu/12oop">Section 1.2</a> of 
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne. 
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Accumulator {
    private int n = 0;          // number of data values
    private double sum = 0.0;   // sample variance * (n-1)
    private double mu = 0.0;    // sample mean

    public Accumulator() {
    }

    public void addDataValue(double x) {
        n++;
        double delta = x - mu;
        mu  += delta / n;
        sum += (double) (n - 1) / n * delta * delta;
    }
    public double mean() {
        return mu;
    }
    public double var() {
        if (n <= 1) return Double.NaN;
        return sum / (n - 1);
    }
    public double stddev() {
        return Math.sqrt(this.var());
    }
    public int count() {
        return n;
    }

    @Override
    public String toString() {
        return "n = " + n + ", mean = " + mean() + ", stddev = " + stddev();
    }

    /**
     * Unit tests the {@code Accumulator} data type.
     * Reads in a stream of real number from standard input;
     * adds them to the accumulator; and prints the mean,
     * sample standard deviation, and sample variance to standard
     * output.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Accumulator stats = new Accumulator();
        while (!StdIn.isEmpty()) {
            double x = StdIn.readDouble();
            stats.addDataValue(x);
        }

        StdOut.printf("n      = %d\n",   stats.count());
        StdOut.printf("mean   = %.5f\n", stats.mean());
        StdOut.printf("stddev = %.5f\n", stats.stddev());
        StdOut.printf("var    = %.5f\n", stats.var());
        StdOut.println(stats);
    }
}