package com.young.algs4.ch02;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 优化版的快速排序
 * 1. Hoare（快速排序的发明者）的二向切分算法
 * 2. 用中位数来选择切分点
 * 3. 对小数组使用插入排序
 *
 * @author youngzy
 * @since 2021-09-04
 */
public class QuickXSort extends QuickSort {
    // 5-15 效果都不错
    private static final int INSERTION_SORT_CUTOFF = 8;

    @Override
    public void sort(Comparable[] a) {
//        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    @Override
    protected void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;

        // 3 小数组使用插入排序
        int n = hi - lo + 1;
        if (n <= INSERTION_SORT_CUTOFF) {
            insertionSort(a, lo, hi);
            return;
        }

        // 1 基础的快速算法
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);

        assert isSorted(a, lo, hi);
    }

    // 2 使用中位数切分
    // 经过试验，将取样大小设为3并用大小居中的元素切分的效果最好
    @Override
    protected int partition(Comparable[] a, int lo, int hi) {
        int n = hi - lo + 1;
        int m = mdian3(a, lo, lo + n/2, hi);
        swap(a, m, lo);

        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];

        // 将取样元素放在末尾作为"哨兵"，这样可以省略对数组边界的判断
        while (less(a[++i], v)) {
            if (i == hi) {
                swap(a, lo, hi);
                return hi;
            }
        }

        while (less(v, a[--j])) {
            if (j == lo + 1)
                return lo;
        }

        while (i < j) {
            swap(a, i, j);
            while (less(a[++i], v));
            while (less(v, a[--j]));
        }

        swap(a, lo, j);

        return j;
    }

    // 返回a[i] a[j] a[k] 大小居中的索引
    private int mdian3(Comparable[] a, int i, int j, int k) {
        return (less(a[i], a[j])) ?
                (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k : i) :
                (less(a[k], a[j]) ? j : less(a[k], a[i]) ? k :i);
    }
}
