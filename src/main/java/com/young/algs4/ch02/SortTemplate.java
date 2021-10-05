package com.young.algs4.ch02;

import edu.princeton.cs.algs4.StdOut;

/**
 * 排序算法类的模版
 *
 * @author youngzy
 * @since 2021-08-28
 */
public abstract class SortTemplate {

    void execute(Comparable[] a) {
        StdOut.println("is sorted before sort:" + isSorted(a));
        sort(a);
        assert isSorted(a);
//        show(a);
    }

    public abstract void sort(Comparable[] a);

    public boolean less(Comparable v1, Comparable v2) {
        return v1.compareTo(v2) < 0;
    }

    public void swap(Comparable[] a, int idxI, int idxJ) {
        Comparable t = a[idxI];
        a[idxI] = a[idxJ];
        a[idxJ] = t;
    }

    // 测试数组元素是否有序
    boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }

    protected void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j-1]); j--) {
                swap(a, j, j-1);
            }
        }
    }

    protected void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }
}
