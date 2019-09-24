package net.zhaoxuyang.common.datastruct;

/**
 *
 * @author Administrator
 */
public class LinkList implements List {

    Node head;
    Node current;
    int size;

    LinkList() {
        head = current = new Node(null);
        size = 0;
    }

    public void index(int i) throws Exception {
        if (i < -1 || i >= size) {
            throw new Exception("参数错误：" + i);
        }
        if (i == -1) {
            return;
        }
        current = head.next;

        int j = 0;
        while ((current != null) && (j < i)) {
            current = current.next;
            j++;
        }
    }

    @Override
    public void insert(int i, Object obj) throws Exception {
        if (i < 0 || i > size) {
            throw new Exception("参数错误：" + i);
        }
        index(i - 1);
        current.setNext(new Node(current.next, obj));
        size++;
    }

    @Override
    public Object delete(int i) throws Exception {
        if (size == 0) {
            throw new Exception("已空：" + size);
        }
        if (i < 0 || i >= size) {
            throw new Exception("参数错误：" + i);
        }
        index(i - 1);
        Object result = current.next.getData();
        current.setNext(current.getNext().getNext());
        size--;
        return result;
    }

    @Override
    public Object get(int i) throws Exception {
        if (i < -1 || i >= size) {
            throw new Exception("参数错误：" + i);
        }
        index(i);
        return current.getData();
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
