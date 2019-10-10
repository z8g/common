
import io.StdDraw;



/******************************************************************************
 *  Compilation:  javac-algs4 TestAlgs4.java
 *  Execution:    java-algs4 TestAlgs4 n
 *  
 *  Simulates the motion of n hard disks, subject to the laws of elastic
 *  collisions. This program is intended to test that algs4.jar is properly
 *  installed.
 * 
 ******************************************************************************/
public class TestAlgs4 {
    public static void main(String[] args) {
        int n = 20;  // number of particles (default 20)
        if (args.length == 1) {
            n = Integer.parseInt(args[0]);
        }

        // enable double buffering to support animations
        StdDraw.enableDoubleBuffering();

        // create the n particles
        Particle[] particles = new Particle[n];
        for (int i = 0; i < n; i++) {
            particles[i] = new Particle();
        }

        // simulate the system
        CollisionSystem system = new CollisionSystem(particles);
        system.simulate(Double.POSITIVE_INFINITY);
    }
}
