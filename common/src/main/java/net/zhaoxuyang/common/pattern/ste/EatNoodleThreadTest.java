package net.zhaoxuyang.common.pattern.ste;

/**
 *
 * @author zhaoxuyang
 */
public class EatNoodleThreadTest {

    public static void main(String[] args) {
        Tableware fork = new Tableware("fork");
        Tableware knife = new Tableware("knife");
        new EatNoodleThread("A", fork, knife).start();
        new EatNoodleThread("B", knife, fork).start();
    }
}
