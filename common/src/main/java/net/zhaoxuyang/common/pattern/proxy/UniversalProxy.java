package net.zhaoxuyang.common.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class UniversalProxy extends MyProxy {

    public UniversalProxy(Object object) {
        super(object);
    }

    public static <T> T createProxy(Object object) {
        ClassLoader classLoader = object.getClass().getClassLoader();
        Class<?>[] classes = object.getClass().getInterfaces();
        InvocationHandler invocationHandler = new MyProxy(object);
        return (T) Proxy.newProxyInstance(classLoader, classes, invocationHandler);
    }
}
