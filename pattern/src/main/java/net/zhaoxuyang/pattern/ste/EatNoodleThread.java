package net.zhaoxuyang.pattern.ste;

import static java.lang.System.out;

/**
 *
 * @author zhaoxuyang
 */
public class EatNoodleThread extends Thread {

    private final String name;
    private final Tableware leftTool;
    private final Tableware rightTool;

    public EatNoodleThread(String name, Tableware leftTool, Tableware rightTool) {
        this.name = name;
        this.leftTool = leftTool;
        this.rightTool = rightTool;
    }

    @Override
    public void run() {
        while (true) {
            this.eat();
        }
    }

    private void eat() {
        synchronized (leftTool) {
            out.println("name:" + name + ",left satrt:" + leftTool);
            synchronized (rightTool) {
                out.println("name:" + name + ",right start:" + rightTool);
                out.println("name:" + name + "eat");
                out.println("name:" + name + ",right end:" + rightTool);
            }
            out.println("name:" + name + ",left end:" + leftTool);
        }
    }

}
