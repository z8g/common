package net.zhaoxuyang.pattern.abstarct_factory;

public class RightBookProduct extends BookProduct{
        @Override
    public void printName() {
        System.out.println(this.getClass().getName());
    }

    @Override
    public void printFactoryName() {
        System.out.println("Right");
    }
}
