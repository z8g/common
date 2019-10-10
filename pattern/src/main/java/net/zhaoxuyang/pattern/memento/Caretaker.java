package net.zhaoxuyang.pattern.memento;

import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class Caretaker {
    private HashMap<String,Memento> memMap = new HashMap<>();
    
    public Memento getMemento(String index) {
        return memMap.get(index);
    }

    public void setMemento(String index, Memento memento) {
        this.memMap.put(index, memento);
    }
    
}
