package net.zhaoxuyang.common.datastruct;

/**
 *
 * @author Administrator
 */
public interface Queue {
    public void append(Object obj) throws Exception;
    public Object delete() throws Exception;
    public Object getFront() throws Exception;
    public boolean notEmpty();
}
