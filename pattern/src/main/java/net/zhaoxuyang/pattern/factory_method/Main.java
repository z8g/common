package net.zhaoxuyang.pattern.factory_method;

public class Main {
    public static void main(String[] args){
        AbstractFactory productFactory = new Factory();
        
        Product book = productFactory.createProduct(BookProduct.class);
        book.method();
        book.abstractMethod();
        
        Product car = productFactory.createProduct(CarProduct.class);
        car.method();
        car.abstractMethod();
    }
}
