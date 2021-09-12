package com.young.algs4.exercises;

import com.young.algs4.ch01.Stopwatch;
import com.young.algs4.ch02.InsertionSort;
import com.young.algs4.ch02.SelectionSort;
import com.young.algs4.ch02.SortTemplate;
import edu.princeton.cs.algs4.StdOut;

/**
 * 练习2.1.7 对于逆序数组，选择排序和插入排序谁更快？
 *
 * 答：选择更快更快
 *
 * @author youngzy
 * @since 2021-08-29
 */
public class E020107 {
    public static void main(String[] args) {
        int N = 10000;
        Integer[] a1 = new Integer[N];
        Integer[] a2 = new Integer[N];

        for (int i = 0; i < N; i++) {
            a1[i] = N - i;
            a2[i] = N - i;
        }

        SortTemplate selection, insertion;
        selection = new SelectionSort();
        insertion = new InsertionSort();

        Stopwatch timer = new Stopwatch();
        selection.sort(a1);
        StdOut.println("selection: " + timer.elapsedTimeSeconds());

//        timer = new Stopwatch();
        timer.reset();
        insertion.sort(a2);
        StdOut.println("insertion: " + timer.elapsedTimeSeconds());

    }
}
