package net.zhaoxuyang.pattern.proxy;

public class Main2 {
    public static void main(String[] args){
        UserMapper object = new UserMapperImpl();
        UserMapper proxy = (UserMapper) UniversalProxy.createProxy(object);
        proxy.insert();
        proxy.delete();
        proxy.update();
        proxy.select();
    }
}