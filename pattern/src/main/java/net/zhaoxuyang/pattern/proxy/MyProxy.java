
package net.zhaoxuyang.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyProxy implements InvocationHandler{

    Class clazz = null;
    Object object = null;
    
    public MyProxy(Object object){
        this.object = object;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.object, args);
        after();
        return result;
    }
    
    private void before(){
        System.out.println("before");
    }
    
    private void after(){
        System.out.println("after\n");
    }
    
}
