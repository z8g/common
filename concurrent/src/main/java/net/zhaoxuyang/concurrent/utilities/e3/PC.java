package net.zhaoxuyang.concurrent.utilities.e3;

/**
 *
 * @author zhaoxuyang
 */
public class PC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Shared s = new Shared();
        new Producer(s).start();
        new Consumer(s).start();
    }

}
