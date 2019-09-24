package net.zhaoxuyang.common.pattern.factory_method;

public abstract class Product {
    public void method(){
        System.out.println("Product.method()");
    }
    public abstract void abstractMethod();
    
}
