package net.zhaoxuyang.common.current.utilities.e7;

/**
 *
 * @author zhaoxuyang
 */
public class PC {

    public static void main(String[] args) {
        Shared s = new Shared();
        new Producer(s).start();
        new Consumer(s).start();
    }
    
}
