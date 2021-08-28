package com.young.algs4.ch02;

/**
 * 希尔排序
 *
 * @author youngzy
 * @since 2021-08-28
 */
public class ShellSort extends SortTemplate {
    @Override
    void sort(Comparable[] a) {
        final int N = a.length;

        // 3x+1 increment sequence
        // 1, 4, 13, 40, 121, 264, 1093...
        int h = 1;
        while (h < N / 3)
            h = 3 * h + 1;

        while (h >= 1) {
            //h-sort the array
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    swap(a, j, j-h);
                }
            }
            assert isHSorted(a, h);
            h /= 3;
        }
        assert isSorted(a);
    }

    // is the array h-sorted?
    private boolean isHSorted(Comparable[] a, int h) {
        for (int i = h; i < a.length; i++) {
            if (less(a[i], a[i - h]))
                return false;
        }
        return true;
    }
}
