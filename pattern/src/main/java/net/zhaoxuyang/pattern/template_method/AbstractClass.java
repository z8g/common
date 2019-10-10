package net.zhaoxuyang.pattern.template_method;

public abstract class AbstractClass {
     protected abstract void start();
     protected abstract void stop();
     public final void publicMethod(){
         System.out.println("公共方法");
     } 
}
