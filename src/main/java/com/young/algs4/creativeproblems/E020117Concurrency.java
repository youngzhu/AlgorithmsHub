package com.young.algs4.creativeproblems;

import edu.princeton.cs.algs4.StdRandom;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 多线程版
 * 将各种排序同时显示
 *
 * @author youngzy
 * @since 2021-09-12
 */
public class E020117Concurrency {
    private static final String[] SORT_METHODS = {"INSERTION", "SELECTION"};
    private static final Executor exec = Executors.newFixedThreadPool(SORT_METHODS.length);

    public static void main(String[] args) {
        Double[] a = randomData();

        Runnable task;

        for (String method : SORT_METHODS) {
            switch (method) {
                case "INSERTION":
//                    task = new Insertion(a);
//                    break;
                case "SELECTION":
                    task = new Selection(a);
                    break;
                default:
                    task = new Selection(a);
            }
            exec.execute(task);
        }
    }

    static Double[] randomData() {
        int n = 20;

        Double[] a = new Double[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform();
        }

        return a;
    }

    private static class Insertion extends SortShow implements Runnable {

        Double[] a;

        public Insertion(Double[] a) {
            this.a = a;
        }

        @Override
        public void run() {
            sort(a);
        }

        @Override
        public void sort(Double[] a) {
            final int N = a.length;

            for (int i = 0; i < N; i++) {
                int j = i;
                for (; j > 0 && less(a[j], a[j - 1]); j--) {
                    swap(a, j, j - 1);
                }
//                show("x", a);
//                show(a, StdDraw.BOOK_LIGHT_BLUE);
                show(a);
            }
        }
    }

    static class Selection extends SortShow implements Runnable {
        Double[] a;

        public Selection(Double[] a) {
            this.a = a;
        }

        @Override
        public void run() {
            sort(a);
        }

        void sort(Double[] a) {
            final int N = a.length;

            for (int i = 0; i < N; i++) {
                int min = i;
                for (int j = i + 1; j < N; j++) {
                    if (less(a[j], a[min]))
                        min = j;
                }
//                show(a, StdDraw.MAGENTA);
                show(a);
                swap(a, i, min);
            }

//        show(a);
        }
    }
}
