package com.young.algs4.ch02;

/**
 * 选择排序
 * @author youngzy
 * @since 2021-08-28
 */
public class SelectionSort extends SortTemplate {
    @Override
    void sort(Comparable[] a) {
        final int N = a.length;

        for (int i = 0; i < N; i++) {
            int min = i;
            // 将a[i] 和 a[i+1]...a[N]中最小的元素交换
            for (int j = i + 1; j < N; j++) {
                // 自作聪明地写了 less(a[j], a[i])
                // 以为i和min是等价的
                // 却忘了在内层循环中，min随时会变
                if (less(a[j], a[min]))
                    min = j;
            }
            if (min > i)
                swap(a, i, min);
            assert isSorted(a, 0, i);
        }
    }
}
