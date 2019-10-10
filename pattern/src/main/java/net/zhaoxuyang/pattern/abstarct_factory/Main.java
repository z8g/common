package net.zhaoxuyang.pattern.abstarct_factory;

public class Main {
    public static void main(String[] args){
       AbstractFactory factory = new LeftFactory();
       
       Product product = factory.createBook();
       product.printName();
       product.printCategory();
       product.printFactoryName();
       
       product = factory.createCar();
       product.printName();
       product.printCategory();
       product.printFactoryName();
       
       factory = new RightFactory();
       product = factory.createBook();
       product.printName();
       product.printCategory();
       product.printFactoryName();
       
       product = factory.createCar();
       product.printName();
       product.printCategory();
       product.printFactoryName();
    }
}
