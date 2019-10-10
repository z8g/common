package net.zhaoxuyang.pattern.singleton;

public class Main {
    public static void main(String[] args){
        Singleton instance = Singleton.getInstance();
        instance.method();
        //不能使用Singleton instance = new Singleton();
    }
}
