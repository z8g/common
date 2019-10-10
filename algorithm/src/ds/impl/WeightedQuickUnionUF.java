package ds.impl;

import ds.UF;

/**
 * 加权 quick-union算法，是目前所有实现中最优的算法
 *
 * @author zhaoxuyang
 */
public class WeightedQuickUnionUF implements UF {

    private final int[] parent;
    private final int[] num;
    private int size;

    public WeightedQuickUnionUF(int n) {
        size = n;
        parent = new int[n];
        num = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            num[i] = 1;
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

        // make smaller root point to larger one
        if (num[rootP] < num[rootQ]) {
            parent[rootP] = rootQ;
            num[rootQ] += num[rootP];
        } else {
            parent[rootQ] = rootP;
            num[rootP] += num[rootQ];
        }
        size--;
    }

}
