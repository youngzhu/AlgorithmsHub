package com.young.algs4.ch02;

/**
 * 自底向上的归并排序
 *
 * @author youngzy
 * @since 2021-08-29
 */
public class MergeSortBU extends Merge {
    @Override
    public void sort(Comparable[] a) {
        int n = a.length;

        Comparable[] aux = new Comparable[n]; // 辅助数组

        /*
        1 1 > 2
        2 2 > 4
        4 4 > 8
        ...
        合并
         */
        for (int len = 1; len < n; len *= 2) {
            for (int lo = 0; lo < n - len; lo += len*2) {
                int mid = lo + len - 1;
                int hi = Math.min(lo + len*2 - 1, n - 1);
                merge(a, aux, lo, mid, hi);
            }
        }
    }
}
