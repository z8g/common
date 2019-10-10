package net.zhaoxuyang.pattern.ste;

import static java.lang.System.out;


/**
 *
 * @author zhaoxuyang
 */
public class EatNoodleThread2 extends Thread {

    private final String name;
    private final TablewarePair pair;

    public EatNoodleThread2(String name, TablewarePair tablewarePair) {
        this.name = name;
        this.pair = tablewarePair;
    }

    @Override
    public void run() {
        while (true) {
            this.eat();
        }
    }

    private void eat() {
        synchronized (pair) {
            out.println("name:" + name + ",left satrt:" + pair.getLeftTool());
            out.println("name:" + name + ",right start:" + pair.getRightTool());
            out.println("name:" + name + "eat");
            out.println("name:" + name + ",right end:" + pair.getRightTool());
            out.println("name:" + name + ",left end:" + pair.getLeftTool());
        }
    }

}
