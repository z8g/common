
package net.zhaoxuyang.pattern.template_method;

public class AClass extends AbstractClass{

    @Override
    public void start() {
        System.out.println("A.start()");
    }

    @Override
    public void stop() {
        System.out.println("A.stop()");
    }
    
}
