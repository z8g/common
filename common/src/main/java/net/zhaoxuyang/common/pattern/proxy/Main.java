package net.zhaoxuyang.common.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args){
        UserMapper object = new UserMapperImpl();
        
        InvocationHandler invocationHandler = new MyProxy(object);
        ClassLoader classLoader = object.getClass().getClassLoader();
        UserMapper proxy = (UserMapper) Proxy.newProxyInstance(classLoader, new Class[]{UserMapper.class}, invocationHandler);
        proxy.insert();
        proxy.delete();
        proxy.update();
        proxy.select();
    }
}
