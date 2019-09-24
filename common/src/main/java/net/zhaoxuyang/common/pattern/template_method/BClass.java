
package net.zhaoxuyang.common.pattern.template_method;

public class BClass extends AbstractClass{

    @Override
    public void start() {
        System.out.println("B.start()");
    }

    @Override
    public void stop() {
        System.out.println("B.stop()");
    }
    
}
