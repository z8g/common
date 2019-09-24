package net.zhaoxuyang.common.datastruct;

/**
 *
 * @author Administrator
 */
public class SeqQueue implements Queue {

    static final int DEFAULT_MAX_SIZE = 20;
    int front;
    int rear;
    int count;
    int maxSize;
    Object[] data;

    public SeqQueue() {
        init(DEFAULT_MAX_SIZE);
    }

    public SeqQueue(int size) {
        init(size);
    }

    private void init(int n) {
        maxSize = n;
        front = rear = 0;
        count = 0;
        data = new Object[n];
    }

    @Override
    public void append(Object obj) throws Exception {
        if (count > 0 && front == rear) {
            throw new Exception("队列已满！");
        }
        data[rear] = obj;
        rear = (rear + 1) % maxSize;
        count++;
    }

    @Override
    public Object delete() throws Exception {
        if (count == 0) {
            throw new Exception("队列已空！");
        }
        Object result = data[front];
        front = (front + 1) % maxSize;
        count--;
        return result;
    }

    @Override
    public Object getFront() throws Exception {
        if (count == 0) {
            throw new Exception("队列已空！");
        }
        return data[front];
    }

    @Override
    public boolean notEmpty() {
        return count != 0;
    }

}
