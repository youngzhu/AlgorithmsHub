package com.young.algs4.ch01;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import org.junit.Before;
import org.junit.Test;

public class UnionFindTest {
    In in;
    int n;

    AbstractUF uf;

    // 不能只加载一次
    // 因为 in 需要不断地读取数据
    @Before
    public void init() {
//        in = new In("algs4/tinyUF.txt");
        in = new In("algs4/mediumUF.txt");
        n = in.readInt();
    }

    @Test
    public void testQuickFind() {
        uf = new QuickFindUF(n);
        double times = test();
        StdOut.println("quick-find cost: " + times);
    }

    private double test() {
        Stopwatch stopwatch = new Stopwatch();
        while (in.hasNextLine()) {
            int p = in.readInt();
            int q = in.readInt();
            if (uf.connect(p, q)) continue;
            uf.union(p, q);
//            StdOut.println(p + " " + q);
//            printArray(uf.root);
        }
        double times = stopwatch.elapsedTime();
        StdOut.println(uf.count + " components");
        return times;
    }

    @Test
    public void testQuickUnion() {
        uf = new QuickUnionUF(n);
        double times = test();
        StdOut.println("quick-union cost: " + times);
    }

    @Test
    public void testWeightedQuickUnion() {
        uf = new WeightedQuickUnionUF(n);
        double times = test();
        StdOut.println("weighted quick-union cost: " + times);
    }

    @Test
    public void testUnionFind() {
        uf = new UF(n);
        double times = test();
        StdOut.println("so far best union-find cost: " + times);
    }

    void printArray(int[] a) {
        for (int i : a) {
            StdOut.print(i + " ");
        }
        StdOut.println();
    }

}