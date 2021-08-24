package com.young.algs4.ch01;

/**
 * @author youngzy
 * @since 2021-08-22
 */
public class QuickUnionUF extends AbstractUF {
    public QuickUnionUF(int n) {
        super(n);
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
        root[rootP] = rootQ;
        count--;
    }
}
