package com.young.algs4.creativeproblems;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

/**
 * 动画显示排序轨迹
 * 子类有
 *
 * @author youngzy
 * @since 2021-08-29
 */
abstract class SortShow {

    abstract void sort(Double[] a);

    void show(Double[] a) {
        int n = a.length;

        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.clear();

        for (int i = 0; i < n; i++) {
            double x = 0.5 * (2 * i + 1) / n;
            double y = a[i] / 2.0;
            double rw = 0.5 / n;
            double rh = a[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
//            sleep(100);
            StdDraw.pause(100);
        }
    }

    void show(String title, Double[] a) {
        int n = a.length;

//        StdDraw.text(0, 0.5, title);
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.clear();

        for (int i = 0; i < n; i++) {
            double x = 0.5 * (2 * i + 1) / n;
            double y = a[i] / 2.0;
            double rw = 0.5 / n;
            double rh = a[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
            StdDraw.enableDoubleBuffering();
            StdDraw.pause(100);
        }
    }

    void show(Double[] a, Color color) {
        int n = a.length;

//        StdDraw.text(0, 0.5, title);
        StdDraw.clear();
//        StdDraw.setPenColor(color);

        for (int i = 0; i < n; i++) {
            double x = 0.5 * (2 * i + 1) / n;
            double y = a[i] / 2.0;
            double rw = 0.5 / n;
            double rh = a[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
            StdDraw.enableDoubleBuffering();
            StdDraw.pause(100);
        }
    }

    boolean less(Double v1, Double v2) {
        return v1.compareTo(v2) < 0;
    }

    void swap(Double[] a, int idxI, int idxJ) {
        Double t = a[idxI];
        a[idxI] = a[idxJ];
        a[idxJ] = t;
    }

}
