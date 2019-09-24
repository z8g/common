package net.zhaoxuyang.common.datastruct;

/**
 *
 * @author Administrator
 */
public interface Stack {
    public void push(Object obj) throws Exception;
    public Object pop() throws Exception;
    public Object getTop() throws Exception;
    public boolean notEmpty();
}
