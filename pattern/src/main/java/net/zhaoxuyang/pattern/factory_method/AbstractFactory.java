package net.zhaoxuyang.pattern.factory_method;

public abstract class AbstractFactory {
    public abstract <T extends Product> T createProduct(Class<T> c);
}
