package com.young.algs4.ch02;

/**
 * 插入排序
 *
 * @author youngzy
 * @since 2021-08-28
 */
public class InsertionSort extends SortTemplate {
    @Override
    public void sort(Comparable[] a) {
        final int N = a.length;

        for (int i = 1; i < N; i++) {
            // 将a[i] 插入到 a[i-1],a[i-2]... 之中
            for (int j = i; j > 0 && less(a[j] ,a[j - 1]); j--) {
                swap(a, j, j - 1);
            }
//            assert isSorted(a, 0, i);
        }

    }
}
