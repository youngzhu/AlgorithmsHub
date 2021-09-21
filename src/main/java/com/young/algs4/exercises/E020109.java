package com.young.algs4.exercises;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

/**
 * 练习2.1.9 跟踪希尔排序的轨迹
 *
 * @author youngzy
 * @since 2021-08-29
 */
public class E020109 extends TraceSort {
    private int line = 0;

    @Override
    public void sort(Comparable[] a) {
        final int N = a.length;

        int h = 1;
        while (h < N / 3)
            h = 3*h + 1;

        while (h >= 1) {
            for (int i = 0; i < N; i++) {
                int j = i;
                for (; j >= h && less(a[j], a[j-h]); j-=h) {
                    swap(a, j, j - h);
                }
                draw(a, h, i, j);
                line++;
            }
            h /= 3;
            footer(a);
            line++;
        }
    }

    void draw(Comparable[] a, int h, int ith, int jth) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(-3.75, line, h+"");
        StdDraw.text(-2.50, line, ith+"");
        StdDraw.text(-1.25, line, jth+"");
        for (int i = 0; i < a.length; i++) {
            if (i == jth)
                StdDraw.setPenColor(StdDraw.BOOK_RED);
            else if (i > ith)
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            else if (i < jth)
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            else if ((i%h) == (jth%h))
                StdDraw.setPenColor(StdDraw.BLACK);
            else
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            StdDraw.text(i, line, a[i]+"");
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
        StdDraw.text(-3.75, -2, "h");
        StdDraw.text(-2.50, -2, "i");
        StdDraw.text(-1.25, -2, "j");
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.line(-4, -1.65, n - 0.5, -1.65);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < n; i++) {
            StdDraw.text(i, -1, a[i]);
        }
    }

    void footer(Comparable[] a) {
        int n = a.length;
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < n; i++) {
            StdDraw.text(i, line, a[i] + "");
        }
    }

    @Override
    void trace() {
        String[] a = readData("algs4/traceShellSort.txt");
        int n = a.length;

        int rows = 0;
        int h = 1;
        while (h < n/3) {
            rows += (n - h + 1);
            h = 3*h + 1;
        }
        rows += (n - h + 1);

        // set canvas size
        StdDraw.setCanvasSize(30*(n+3), 30*(rows+3));
        StdDraw.setXscale(-4, n+1);
        StdDraw.setYscale(rows, -4);
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 13));

        // draw the header
        header(a);

        // sort
        sort(a);
    }

    public static void main(String[] args) {
        E020109 sort = new E020109();

        sort.trace();
    }
}
