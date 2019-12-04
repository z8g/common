package refactor.observer;

public class Teacher implements Observer {

    @Override
    public void notify(String text) {
        if(text != null && text.contains("教学")){
            System.out.println("teacher:"+text);
        }
    }
}
