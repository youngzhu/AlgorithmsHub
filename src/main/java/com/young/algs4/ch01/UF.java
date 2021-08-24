package com.young.algs4.ch01;

/**
 * 路径压缩算法（目前最优算法）
 *
 * @author youngzy
 * @since 2021-08-22
 */
public class UF extends AbstractUF {
    private byte[] rank; // 原文备注说 值 不会大于31，没明白为什么

    public UF(int n) {
        super(n);
        rank = new byte[n];
        for (int i = 0; i < n; i++) {
            rank[i] = 0;
        }
    }

    @Override
    public int find(int p) {
        validate(p);
        while (p != root[p]) {
            root[p] = root[root[p]]; // 路径压缩
            p = root[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        if (rank[rootP] < rank[rootQ])
            root[rootP] = rootQ;
        else if (rank[rootP] > rank[rootQ])
            root[rootQ] = rootP;
        else {
            root[rootQ] = rootP;
            rank[rootP]++;
        }

        count--;
    }
}
