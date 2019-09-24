package net.zhaoxuyang.common.datastruct;


/**
 *
 * @author Administrator
 */
public class TestLinkList {

    public static void main(String[] args) throws Exception {
        List list = new LinkList();
        for (int i = 0; i < 100; i++) {
            list.insert(i, "data" + i);
            System.out.println(list.get(i));
        }
        System.out.println(list.size());
        System.out.println(list.delete(10));
        System.out.println(list.size());
        System.out.println(list.get(10));

    }
}
