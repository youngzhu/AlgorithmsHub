package com.young.algs4.exercise;

import com.young.algs4.ch02.SelectionSort;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

/**
 * 练习2.1.1 跟踪选择排序的轨迹
 *
 * @author youngzy
 * @since 2021-08-29
 */
public class E020101 extends SelectionSort {
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

    private void draw(Comparable[] a, int row, int ith, int min) {
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

    private void header(String[] a) {
        int n = a.length;
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(n/2.0, -3, "a[ ]");
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

    private void footer(String[] a) {
        int n = a.length;
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < n; i++) {
            StdDraw.text(i, n, a[i]);
        }
    }

    public static void main(String[] args) {
        In in = new In("algs4/traceSort.txt");
        String[] a = in.readAllStrings();

        int n = a.length;

        // set canvas size
        StdDraw.setCanvasSize(30*(n+3), 30 * (n+3));
        StdDraw.setXscale(-3, n+1);
        StdDraw.setYscale(n+1, -3);
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 13));

        E020101 selectionSort = new E020101();

        // draw the header
        selectionSort.header(a);

        // sort
        selectionSort.sort(a);

        // draw the footer
        selectionSort.footer(a);
    }
}
