package net.zhaoxuyang.common.pattern.abstarct_factory;

public class RightCarProduct extends CarProduct{
        @Override
    public void printName() {
        System.out.println(this.getClass().getName());
    }

    @Override
    public void printFactoryName() {
        System.out.println("Right");
    }
}
