package net.zhaoxuyang.common.datastruct;

/**
 *
 * @author Administrator
 */
public class LinkQueue implements Queue {

    Node front;
    Node rear;
    int count;

    public LinkQueue() {
        init();
    }

    private void init() {
        front = rear = null;
        count = 0;
    }

    @Override
    public void append(Object obj) throws Exception {
        Node newNode = new Node(null, obj);
        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;
        if (front == null) {
            front = newNode;
        }
        count++;
    }

    @Override
    public Object delete() throws Exception {
        if (count == 0) {
            throw new Exception("队列已空！");
        }
        Node temp = front;
        front = front.next;
        count--;
        return temp.getData();
    }

    @Override
    public Object getFront() throws Exception {
        if (count == 0) {
            throw new Exception("队列已空！");
        }
        return front.getData();
    }

    @Override
    public boolean notEmpty() {
        return count != 0;
    }

}
