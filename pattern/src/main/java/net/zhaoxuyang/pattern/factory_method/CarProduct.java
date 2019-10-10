package net.zhaoxuyang.pattern.factory_method;

public class CarProduct extends Product{
    @Override
    public void abstractMethod() {
        System.out.println(this.getClass().getName());
        System.out.println("abstractMethod()");
    }
}
