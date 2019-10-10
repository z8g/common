package ds.impl;

import ds.UF;

/**
 *
 * @author zhaoxuyang
 */
public class QuickFindUF implements UF {

    private final int[] id;
    private int size;

    public QuickFindUF(int n) {
        size = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int find(int p) {
        validate(p, id.length);
        return id[p];
    }

    @Override
    public boolean connected(int p, int q) {
        validate(p, id.length);
        validate(q, id.length);
        return id[p] == id[q];
    }

    @Override
    public void union(int p, int q) {
        validate(p, id.length);
        validate(q, id.length);
        int pID = id[p];
        int qID = id[q];

        if (pID == qID) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
        size--;
    }

}
