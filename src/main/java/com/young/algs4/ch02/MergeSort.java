package com.young.algs4.ch02;

/**
 * 自顶向下的归并排序
 *
 * @author youngzy
 * @since 2021-08-29
 */
public class MergeSort extends Merge {
    @Override
    public void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length]; // 辅助数组
        sort(a, aux, 0, a.length - 1);
    }

    // 对数组a[lo...hi]归并排序
    private void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;

        int mid = lo + (hi - lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

}
