package com.young.algs4.ch02;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 快速排序
 *
 * @author youngzy
 * @since 2021-09-04
 */
public class QuickSort extends SortTemplate {

    @Override
    public void sort(Comparable[] a) {
//        StdRandom.shuffle(a); // 消除对输入的依赖，保证无序
        sort(a, 0, a.length - 1);
    }

    protected void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
        assert isSorted(a, lo, hi);
    }

    protected int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];

        while (true) {
            // 判断左侧的是否都比v小
            while (less(a[++i], v)) {
                if (i == hi)
                    break;
            }
            // 判断右侧的是否都比v大
            while (less(v, a[--j])) {
                // 这个条件是多余的，因为lo就是切分点（哨兵），自己不可能比自己小
//                if (j == lo)
//                    break;
            }

            if (i >= j)
                break;

            swap(a, i, j);
        }

        // 将切分点a[lo]的值，放到正确的位置 a[j]
        swap(a, lo, j);

        // a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }
}
