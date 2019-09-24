package net.zhaoxuyang.common.datastruct;

/**
 *
 * @author Administrator
 */
public class SeqStack implements Stack {

    final int DEFAULT_MAX_SIZE = 20;
    int top;
    Object[] stack;
    int maxSize;

    public SeqStack() {
        init(DEFAULT_MAX_SIZE);
    }

    public SeqStack(int size) {
        init(size);
    }

    private void init(int n) {
        maxSize = n;
        top = 0;
        stack = new Object[n];
    }

    @Override
    public void push(Object obj) throws Exception {
        if (top == maxSize) {
            throw new Exception("栈已满：" + maxSize);
        }
        stack[top] = obj;
        ++top;
    }

    @Override
    public Object pop() throws Exception {
        if (top == 0) {
            throw new Exception("栈空！");
        }
        top--;
        return stack[top];
    }

    @Override
    public Object getTop() throws Exception {
        if (top == 0) {
            throw new Exception("栈空！");
        }
        return stack[top - 1];
    }

    @Override
    public boolean notEmpty() {
        return top > 0;
    }

}
