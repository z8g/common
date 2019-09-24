package net.zhaoxuyang.common.datastruct;

/**
 *
 * @author Administrator
 */
public class Node {
    Object data;
    Node next;
    Node(Node next){
        this.next = next;
    }
    Node(Node next,Object obj){
        data = obj;
        this.next = next;
    }
    public Node getNext(){
        return next;
    }
    public void setNext(Node next){
        this.next = next;
    }
    public Object getData(){
        return data;
    }
    
    public void setData(Object data){
        this.data = data;
    }
    
    @Override
    public String toString(){
        return data.toString();
    }
}
