package com.young.algs4.experiments;

import com.young.algs4.ch02.InsertionSort;

/**
 * 原版
 *
 * 测试结果：1.1x
 *
 * 结果表明还没我写的好，哈哈
 *
 * @author youngzy
 * @since 2021-10-05
 */
public class InsertionX01 extends InsertionSort {
    @Override
    public void sort(Comparable[] a) {
        final int N = a.length;

        int swapCount = 0;
        for (int i = N - 1; i > 0; i--) {
            if (less(a[i], a[i-1])) {
                swap(a, i, i - 1);
                swapCount++;
            }
        }
        if (swapCount == 0)
            return;

        // 跟E020125比，因为设置了哨兵，i从 2 开始
        for (int i = 2; i < N; i++) {
            Comparable t = a[i];
            int j = i;
            // 比 t 大的，右移一位（而不是交换）
            while (less(t, a[j - 1])) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = t;
        }

    }

    public static void main(String[] args) {
        InsertionX01 sorter = new InsertionX01();
        Integer[] a = {1,1,13,6,4,5,6,7,8,4,3};
        sorter.sort(a);
        sorter.show(a);
    }
}
