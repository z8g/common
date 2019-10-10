package ds.impl;

import ds.UF;

public class QuickUnionUF implements UF {

    private final int[] parent;
    private int size;

    public QuickUnionUF(int n) {
        parent = new int[n];
        size = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int find(int p) {
        validate(p, parent.length);
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        parent[rootP] = rootQ;
        size--;
    }
}
