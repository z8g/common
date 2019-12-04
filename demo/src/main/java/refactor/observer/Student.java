package refactor.observer;

public class Student implements Observer {

    @Override
    public void notify(String text) {
        if(text != null && text.contains("学习")){
            System.out.println("student:"+text);
        }
    }
}
