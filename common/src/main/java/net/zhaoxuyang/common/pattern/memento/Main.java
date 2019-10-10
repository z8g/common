package net.zhaoxuyang.common.pattern.memento;

public class Main {
    public static void main(String[] args){
        Caretaker caretaker = new Caretaker();
        
        User user = new User();
        user.setState1("111");
        user.setState2("222");
        user.setState3("333");
        System.err.println("初始：");
        System.out.println(user);
        caretaker.setMemento("001", user.createMemento());
        System.out.println("已添加到备忘录[001]");
        
        user.setState1("1111");
        user.setState2("2222");
        System.err.println("进行修改：");
        System.out.println(user);
        caretaker.setMemento("002", user.createMemento());
        System.out.println("已添加到备忘录[002]");
 
        user.restoreMemento(caretaker.getMemento("001"));
        System.err.println("恢复到备忘录[001]");
        System.out.println(user);    
        
        user.restoreMemento(caretaker.getMemento("002"));
        System.err.println("恢复到备忘录[002]");
        System.out.println(user);
    }
}
