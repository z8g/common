package net.zhaoxuyang.common.datastruct;

/**
 *
 * @author Administrator
 */
public class SeqPQueue implements Queue {

    static final int DEFAULT_MAX_SIZE = 10;
    int front;
    int rear;
    int count;
    int maxSize;
    Element[] data;

    public SeqPQueue() {
        init(DEFAULT_MAX_SIZE);
    }

    public SeqPQueue(int size) {
        init(size);
    }

    private void init(int n) {
        maxSize = n;
        front = rear = 0;
        count = 0;
        data = new Element[n];
    }

    @Override
    public void append(Object obj) throws Exception {
        if (count > maxSize) {
            throw new Exception("队列已满：" + maxSize);
        }
        data[rear] = (Element) obj;
        rear = rear + 1;
        count++;
    }

    @Override
    public Object delete() throws Exception {
        if (count == 0) {
            throw new Exception("队列已空！");
        }

        Element min = data[0];
        int minIndex = 0;
        for (int i = 0; i < count; i++) {
            if (data[i].getPriority() < min.getPriority()) {
                min = data[i];
                minIndex = i;
            }
        }

        for (int i = minIndex + 1; i < count; i++) {
            data[i - 1] = data[i];

        }
        rear = rear - 1;
        count--;
        return min;
    }

    @Override
    public Object getFront() throws Exception {
        if (count == 0) {
            throw new Exception("队列已空！");
        }
        Element min = data[0];
        int minIndex = 0;
        for (int i = 0; i < count; i++) {
            if (data[i].getPriority() < min.getPriority()) {
                min = data[i];
                minIndex = i;
            }
        }
        return min;
    }

    @Override
    public boolean notEmpty() {
        return count != 0;
    }

}
