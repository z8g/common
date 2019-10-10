package net.zhaoxuyang.pattern.template_method;

public class Main {
    public static void main(String[] args){
        AbstractClass a = new AClass();
        a.publicMethod();
        a.start();
        a.stop();
        
        AbstractClass b = new BClass();
        b.publicMethod();
        b.start();
        b.stop();
    }
}
