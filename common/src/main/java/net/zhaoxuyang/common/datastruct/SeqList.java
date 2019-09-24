package net.zhaoxuyang.common.datastruct;

/**
 *
 * @author Administrator
 */
public class SeqList implements List {

    final int DEFAULT_MAX_SIZE = 20;
    int maxSize;
    int size;
    Object[] data;

    public SeqList() {
        init(DEFAULT_MAX_SIZE);
    }

    public SeqList(int size) {
        init(size);
    }

    private void init(int n) {
        maxSize = n;
        size = 0;
        data = new Object[n];
    }

    @Override
    public void insert(int i, Object obj) throws Exception {
        if (isEmpty()) {
            throw new Exception("表已空：" + size);
        }
        if (i < 0 || i >= maxSize) {
            throw new Exception("参数错误：" + i);
        }
        for (int j = size; j > i; j--) {
            data[j] = data[j - 1];
        }
        data[i] = obj;
        size++;
    }

    @Override
    public Object delete(int i) throws Exception {
        if (size == 0) {
            throw new Exception("表已满：" + size);
        }
        if (i < 0 || i >= size) {
            throw new Exception("参数错误：" + i);
        }
        Object result = data[i];
        for (int j = i; j < size - 1; j++) {
            data[j] = data[j + 1];
        }
        size--;
        return result;

    }

    @Override
    public Object get(int i) throws Exception {
        if (i < 0 || i >= size) {
            throw new Exception("参数错误：" + i);
        }
        return data[i];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
}
