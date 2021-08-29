package com.young.algs4.exercise;

import com.young.algs4.ch01.Stopwatch;
import com.young.algs4.ch02.InsertionSort;
import com.young.algs4.ch02.SelectionSort;
import com.young.algs4.ch02.SortTemplate;
import edu.princeton.cs.algs4.StdOut;

/**
 * 练习2.1.6 在所有值都相同时，选择排序和插入排序，谁更快？
 *
 * 答：插入更快
 *
 * @author youngzy
 * @since 2021-08-29
 */
public class E020106 {
    public static void main(String[] args) {
        int N = 100000;
        Integer[] a = new Integer[N];

        for (int i = 0; i < N; i++) {
            a[i] = 1;
        }

        SortTemplate selection, insertion;
        selection = new SelectionSort();
        insertion = new InsertionSort();

        Stopwatch timer = new Stopwatch();
        selection.sort(a);
        StdOut.println("selection: " + timer.elapsedTimeSeconds());

//        timer = new Stopwatch();
        timer.reset();
        insertion.sort(a);
        StdOut.println("insertion: " + timer.elapsedTimeSeconds());

    }
}
