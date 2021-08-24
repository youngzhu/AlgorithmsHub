package com.young.algs4.ch01;

/**
 * union-find算法
 *
 * @author youngzy
 * @since 2021-08-21
 */
public abstract class AbstractUF {
    protected int count;
    protected int[] root;

    public AbstractUF(int n) {
        if (n <= 0)
            throw new IllegalArgumentException();
        this.count = n;
        root = new int[count];
        for (int i = 0; i < n; i++)
            root[i] = i;
    }

    public abstract int find(int p);
    public abstract void union(int p, int q);

    public boolean connect(int p, int q) {
        validate(p);
        validate(q);
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }

    protected void validate(int p) {
        int n = root.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " should between 0 and " + (n - 1));
        }
    }
}
