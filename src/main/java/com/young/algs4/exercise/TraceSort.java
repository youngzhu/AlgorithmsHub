package com.young.algs4.exercise;

import com.young.algs4.ch02.SortTemplate;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

/**
 * 跟踪算法轨迹的基类
 * 子类有
 * E020101
 * E020104
 * E020109
 *
 * @author youngzy
 * @since 2021-08-29
 */
abstract class TraceSort extends SortTemplate {
    void draw(Comparable[] a, int row, int ith, int min) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(-2.50, row, ith + "");
        StdDraw.text(-1.25, row, min + "");
        for (int i = 0; i < a.length; i++) {
            if (i == min)
                StdDraw.setPenColor(StdDraw.BOOK_RED);
            else if (i < ith)
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            else
                StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.text(i, row, a[i] + "");
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

    void footer(String[] a) {
        int n = a.length;
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < n; i++) {
            StdDraw.text(i, n, a[i]);
        }
    }

    void trace() {
        In in = new In("algs4/traceSort.txt");
        String[] a = in.readAllStrings();

        int n = a.length;

        // set canvas size
        StdDraw.setCanvasSize(30 * (n + 3), 30 * (n + 3));
        StdDraw.setXscale(-3, n + 1);
        StdDraw.setYscale(n + 1, -3);
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 13));

        // draw the header
        header(a);

        // sort
        sort(a);

        // draw the footer
        footer(a);
    }
}
