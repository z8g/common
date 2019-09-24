package net.zhaoxuyang.common.pattern.abstarct_factory;

public class RightFactory implements AbstractFactory{

    @Override
    public Product createCar() {
        return new RightCarProduct();
    }

    @Override
    public Product createBook() {
        return new RightBookProduct();
    }

}
