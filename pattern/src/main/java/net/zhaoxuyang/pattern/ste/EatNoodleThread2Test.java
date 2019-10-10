package net.zhaoxuyang.pattern.ste;

/**
 *
 * @author zhaoxuyang
 */
public class EatNoodleThread2Test {

    public static void main(String[] args) {
        Tableware fork = new Tableware("fork");
        Tableware knife = new Tableware("knife");
        
        TablewarePair pair = new TablewarePair(fork, knife);

        new EatNoodleThread2("A", pair).start();
        new EatNoodleThread2("B", pair).start();
    }
}
