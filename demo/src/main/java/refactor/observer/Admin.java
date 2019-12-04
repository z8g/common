package refactor.observer;

public class Admin implements Observer {

    @Override
    public void notify(String text) {
        if(text != null && text.contains("管理")){
            System.out.println("admin:"+text);
        }
    }
}
