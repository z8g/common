/*
单例模式（Sinleton Pattern）定义：
Ensure a class has only one instance, and provide a global point of access to it.
（确保一个类只有一个实例，而且自行实例化并向系统提供这个实例）
*/
package net.zhaoxuyang.common.pattern.singleton;

public class Singleton {    
    
    private static class SingletonInstance{
        static Singleton instance = new Singleton();
    }
    private Singleton(){}
    public static Singleton getInstance(){
        return SingletonInstance.instance;
    }

    public void method(){
        System.out.println("执行单例模式的一个公共方法");
    }
    
}
