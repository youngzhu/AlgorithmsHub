package com.young.algs4.ch01;

/**
 * 加权的quick-union
 *
 * @author youngzy
 * @since 2021-08-22
 */
public class WeightedQuickUnionUF extends AbstractUF {
    private int[] size;

    public WeightedQuickUnionUF(int n) {
        super(n);
        size = new int[n];
        for (int i = 0; i < n; i++)
            size[i] = 1;
    }

    @Override
    public int find(int p) {
        validate(p);
        while (p != root[p])
            p = root[p];
        return p;
    }

    @Override
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;

        // 将小树连到大树上
        if (size[rootP] < size[rootQ]) {
            root[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            root[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }
}
