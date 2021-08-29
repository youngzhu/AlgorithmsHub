package com.young.algs4.exercise;

/**
 * 练习2.1.1 跟踪选择排序的轨迹
 *
 * @author youngzy
 * @since 2021-08-29
 */
public class E020101 extends TraceSort {
    @Override
    public void sort(Comparable[] a) {
        final int N = a.length;

        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min]))
                    min = j;
            }
            draw(a, i, i, min);
            swap(a, i, min);
        }
    }

    public static void main(String[] args) {
        E020101 selectionSort = new E020101();

        selectionSort.trace();
    }
}
