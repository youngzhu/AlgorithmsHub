package com.young.algs4.ch02;

import com.young.algs4.experiments.E020124;
import com.young.algs4.experiments.E02012401;
import com.young.algs4.experiments.E020125;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * 比较两种排序算法
 *
 * @author youngzy
 * @since 2021-08-28
 */
public class SortCompare {
    private SortCompare() {}

    public static double time(String alg, Comparable[] a) {
        Stopwatch timer = new Stopwatch();
        switch (alg) {
            case "insertion":
                new InsertionSort().sort(a);
                break;
            case "selection":
                new SelectionSort().sort(a);
                break;
            case "shell":
                new ShellSort().sort(a);
                break;
            case "merge":
                new MergeSort().sort(a);
                break;
            case "mergebu":
                new MergeSortBU().sort(a);
                break;
            case "mergex":
                new MergeSortX().sort(a);
                break;
            case "quick":
                new QuickSort().sort(a);
                break;
            case "quick3way":
                new Quick3waySort().sort(a);
                break;
            case "quickx":
                new QuickXSort().sort(a);
                break;
            case "e0124":
                new E020124().sort(a);
                break;
            case "e012401":
                new E02012401().sort(a);
                break;
            case "e0125":
                new E020125().sort(a);
                break;
            default:
                throw new IllegalArgumentException("unknown algorithm: " + alg);
        }
        return timer.elapsedTime();
    }

    /**
     * 使用alg算法将T个长度为N的数组排序
     * @param alg
     * @param N
     * @param T
     * @return
     */
    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N; j++) {
                a[j] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = StdIn.readString();
        String alg2 = StdIn.readString();
        int N = StdIn.readInt();
        int T = StdIn.readInt();

        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);

        String faster = alg1;
        String slower = alg2;
        double times = t2 / t1;
        if (times < 1.0) {
            faster = alg2;
            slower = alg1;
            times = 1/times;
        }

        StdOut.printf("For %d random Doubles\n    %s is", N, faster);
        StdOut.printf(" %.1f times faster than %s\n", times, slower);
    }

}
