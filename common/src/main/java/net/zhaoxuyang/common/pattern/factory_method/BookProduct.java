package net.zhaoxuyang.common.pattern.factory_method;

public class BookProduct extends Product{

    @Override
    public void abstractMethod() {
        System.out.println(this.getClass().getName());
        System.out.println("abstractMethod()");
    }
    
}
