package net.zhaoxuyang.common.datastruct;

/**
 *
 * @author Administrator
 */
public interface List {
    public void insert(int i, Object obj) throws Exception;
    public Object delete(int i) throws Exception;
    public Object get(int i)throws Exception;
    public int size();
    public boolean isEmpty();
}
