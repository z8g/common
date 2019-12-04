package refactor.observer;

import java.util.ArrayList;
import java.util.List;

public class JavaSubject implements Subject {

    private final List<Observer> observerList = new ArrayList<>();

    @Override
    public void register(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void notify(String text) {
        observerList.forEach(o->o.notify(text));
    }
}
