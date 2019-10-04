package ds.impl;

import ds.UF;

/**
 * 动态连通性
 *
 * @author zhaoxuyang
 */
public class DefaultUF implements UF {

    private int[] parent;
    private byte[] rank;
    private int size;

    public DefaultUF(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        size = n;
        parent = new int[n];
        rank = new byte[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    @Override
    public int find(int p) {
        validate(p, parent.length);
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    @Override
    public int size() {
        return size;
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
        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        } else if (rank[rootQ] > rank[rootP]) {
            parent[rootQ] = rootP;
        } else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        size--;
    }

}
