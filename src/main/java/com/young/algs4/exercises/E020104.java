package com.young.algs4.exercises;

import edu.princeton.cs.algs4.StdDraw;

/**
 * 练习2.1.4 跟踪插入排序的轨迹
 *
 * @author youngzy
 * @since 2021-08-29
 */
public class E020104 extends TraceSort {
    @Override
    public void sort(Comparable[] a) {
        final int N = a.length;

        for (int i = 0; i < N; i++) {
            int j = i;
            for (; j > 0 && less(a[j], a[j - 1]); j--) {
                swap(a, j, j - 1);
            }
            draw(a, i, i, j);
        }
    }

    void draw(Comparable[] a, int row, int ith, int jth) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(-2.50, row, ith + "");
        StdDraw.text(-1.25, row, jth + "");
        for (int i = 0; i < a.length; i++) {
            if (i == jth)
                StdDraw.setPenColor(StdDraw.BOOK_RED);
            else if (i < jth)
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            else if (i > ith)
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            else
                StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.text(i, row, a[i] + "");
        }
    }

    @Override
    void header(String[] a) {
        int n = a.length;
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(n / 2.0, -3, "a[ ]");
        for (int i = 0; i < n; i++) {
            StdDraw.text(i, -2, i + "");
        }
        StdDraw.text(-2.50, -2, "i");
        StdDraw.text(-1.25, -2, "j");
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.line(-3, -1.65, n - 0.5, -1.65);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < n; i++) {
            StdDraw.text(i, -1, a[i]);
        }
    }

    public static void main(String[] args) {
        E020104 sort = new E020104();

        sort.trace();
    }
}
