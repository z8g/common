package net.zhaoxuyang.pattern.abstarct_factory;

public abstract class CarProduct implements Product {

    @Override
    public void printCategory() {
        System.out.println("Car");
    }
}
