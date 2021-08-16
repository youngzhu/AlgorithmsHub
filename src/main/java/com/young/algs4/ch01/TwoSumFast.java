package com.young.algs4.ch01;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

/**
 * 计算和为0的整数对的数目
 *
 * @author youngzy
 * @since 2021-08-16
 */
public class TwoSumFast {
    public static int count(int[] a) {
        Arrays.sort(a);

        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N && a[i] <= 0; i++) {
            // a[j]=-a[i]
            // j > i 覆盖了以下三种情况
            // 1） 返回-1，i>0
            // 2） j > i，正确数据
            // 3） 0 < j < i，重复的数据对
            if (BinarySearch.indexOf(a, -a[i]) > i) {
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        In in = new In("algs4/2Kints.txt");

        int[] a = in.readAllInts();

        Stopwatch timer = new Stopwatch();
        int count = count(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println(count(a));
    }
}
