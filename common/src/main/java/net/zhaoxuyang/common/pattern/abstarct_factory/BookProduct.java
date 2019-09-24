package net.zhaoxuyang.common.pattern.abstarct_factory;

public abstract class BookProduct implements Product{
    @Override
    public void printCategory(){
        System.out.println("Book");
    }
}
