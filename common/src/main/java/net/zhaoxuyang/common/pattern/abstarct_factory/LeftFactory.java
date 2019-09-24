package net.zhaoxuyang.common.pattern.abstarct_factory;

public class LeftFactory implements AbstractFactory{

    @Override
    public Product createCar() {
        return new LeftCarProduct();
    }

    @Override
    public Product createBook() {
        return new LeftBookProduct();
    }

}
