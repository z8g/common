package ds.test;

import ds.UF;
import ds.impl.DefaultUF;
import ds.impl.QuickFindUF;
import ds.impl.QuickUnionUF;

/**
 * Union Find算法
 * @author zhaoxuyang
 */
public class UFTest {

    public static void main(String[] args) {
        UF uf;
        int findResult;

        uf = new QuickFindUF(10);
        uf.union(4, 3);
        uf.union(3, 8);
        uf.union(6, 5);
        uf.union(9, 4);
        uf.union(2, 1);
        uf.union(5, 0);
        uf.union(7, 2);
        uf.union(6, 1);
        findResult = uf.find(3);
        System.out.println(findResult);
        System.out.println(uf.size());
        System.out.println(uf.connected(4, 3));
        System.out.println(uf.connected(9, 3));

        uf = new DefaultUF(10);
        uf.union(4, 3);
        uf.union(3, 8);
        uf.union(6, 5);
        uf.union(9, 4);
        uf.union(2, 1);
        uf.union(5, 0);
        uf.union(7, 2);
        uf.union(6, 1);
        findResult = uf.find(3);
        System.out.println(findResult);
        System.out.println(uf.size());
        System.out.println(uf.connected(4, 3));
        System.out.println(uf.connected(9, 3));

        uf = new QuickUnionUF(10);
        uf.union(4, 3);
        uf.union(3, 8);
        uf.union(6, 5);
        uf.union(9, 4);
        uf.union(2, 1);
        uf.union(5, 0);
        uf.union(7, 2);
        uf.union(6, 1);
        findResult = uf.find(3);
        System.out.println(findResult);
        System.out.println(uf.size());
        System.out.println(uf.connected(4, 3));
        System.out.println(uf.connected(9, 3));

    }
}
