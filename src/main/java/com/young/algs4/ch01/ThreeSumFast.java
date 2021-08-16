package com.young.algs4.ch01;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

/**
 * N^2logN vs N^3
 * 0.091 vs 3.65
 *
 * @author youngzy
 * @since 2021-08-16
 */
public class ThreeSumFast {
    public static int count(int[] a) {
        Arrays.sort(a);

        int N = a.length;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (BinarySearch.indexOf(a, -a[i] - a[j]) > j) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
//        In in = new In("algs4/1Kints.txt");
        In in = new In("algs4/2Kints.txt");

        int[] a = in.readAllInts();

        Stopwatch timer = new Stopwatch();
        int count = count(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println(count(a));
    }
}
