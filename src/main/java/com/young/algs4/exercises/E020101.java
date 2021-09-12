package com.young.algs4.exercises;

import edu.princeton.cs.algs4.StdDraw;

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

    void header(String[] a) {
        int n = a.length;
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(n / 2.0, -3, "a[ ]");
        for (int i = 0; i < n; i++) {
            StdDraw.text(i, -2, i + "");
        }
        StdDraw.text(-2.50, -2, "i");
        StdDraw.text(-1.25, -2, "min");
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.line(-3, -1.65, n - 0.5, -1.65);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < n; i++) {
            StdDraw.text(i, -1, a[i]);
        }
    }

    public static void main(String[] args) {
        E020101 selectionSort = new E020101();

        selectionSort.trace();
    }
}
