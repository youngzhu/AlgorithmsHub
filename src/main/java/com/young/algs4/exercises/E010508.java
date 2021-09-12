package com.young.algs4.exercises;

import com.young.algs4.ch01.QuickFindUF;
import edu.princeton.cs.algs4.StdOut;

/**
 * 练习1.5.8 用一个反例证明以下union的实现是错误的
 *
 * @author youngzy
 * @since 2021-08-28
 */
public class E010508 {
    public static void main(String[] args) {
//        FooQuickFindUF uf = new FooQuickFindUF(6);
        QuickFindUF uf = new QuickFindUF(6);
        /*
        三个元素 x < y < z
        第一步 z-y， 保证a[y]改变时，z还没遍历到
        第二步 y-x， 保证y的改变
        第三步 z-x或者x-z， z和x应该关联，却没有关联，出错
         */
        uf.union(5, 4);
        uf.union(4, 2);
//        uf.union(5, 2);
        uf.union(2, 5);
        StdOut.println(uf.count() + " components");
    }

    private static class FooQuickFindUF extends QuickFindUF {

        public FooQuickFindUF(int n) {
            super(n);
        }

        @Override
        public void union(int p, int q) {
            if (connect(p, q)) return;

            for (int i = 0; i < root.length; i++) {
                if (root[i] == root[p])
                    root[i] = root[q];
            }
            count--;
        }
    }
}
