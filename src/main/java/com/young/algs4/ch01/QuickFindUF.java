package com.young.algs4.ch01;

/**
 * @author youngzy
 * @since 2021-08-21
 */
public class QuickFindUF extends AbstractUF {

    public QuickFindUF(int n) {
        super(n);
    }

    @Override
    public int find(int p) {
        return root[p];
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;

        for (int i = 0; i < root.length; i++) {
            if (root[i] == pRoot)
                root[i] = qRoot;
        }

        count--;
    }
}
