/**
 * 单例模式
 * 1.Singleton最多只有一个实例，在不考虑反射强行突破访问限制的情况下。
 * 2.保证了并发访问的情况下，不会发生由于并发而产生多个实例。
 * 3.保证了并发访问的情况下，不会由于初始化动作未完全完成而造成使用了尚未正确初始化的实例。
 */
package net.zhaoxuyang.common.pattern.singleton;

/**
 *
 * @author zhaoxuyang
 */
public class Singleton {
    
    private Singleton(){}
    public Singleton getInstance(){
        return SingletonInstance.instance;
    }
    public static class SingletonInstance{
        static Singleton instance = new Singleton();
    }
}
