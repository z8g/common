package net.zhaoxuyang.common.datastruct;

/**
 *
 * @author Administrator
 */
public class LinkStack implements Stack{

    Node head;
    int size;
    
    public void linkStack(){
        head = null;
        size = 0;
    }
    
    @Override
    public void push(Object obj) throws Exception {
        head = new Node(head,obj);
        size++;
    }

    @Override
    public Object pop() throws Exception {
        if(size == 0){
            throw new Exception("栈空！");
        }
        Object result = head.data;
        head = head.next;
        size --;
        return result;
    }

    @Override
    public Object getTop() throws Exception {
        return head.data;
    }

    @Override
    public boolean notEmpty() {
        return head !=null;
    }
    
}
