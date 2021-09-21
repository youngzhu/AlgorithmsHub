package com.young.algs4.exercises;

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

    abstract void header(String[] a);

    void footer(Comparable[] a) {
        int n = a.length;
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < n; i++) {
            StdDraw.text(i, n, a[i] + "");
        }
    }

    String[] readData() {
        return readData("algs4/traceSort.txt");
    }

    String[] readData(String path) {
        In in = new In(path);
        return in.readAllStrings();
    }

    void trace() {
        String[] a = readData();

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
