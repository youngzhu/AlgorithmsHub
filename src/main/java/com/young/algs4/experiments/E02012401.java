package com.young.algs4.experiments;

import com.young.algs4.ch02.SortTemplate;

/**
 * 标准答案
 *
 * 测试结果：
 *
 * @author youngzy
 * @since 2021-10-05
 */
public class E02012401 extends SortTemplate {
    @Override
    public void sort(Comparable[] a) {
        final int N = a.length;

        // 1.1x
//        for (int i = N - 1; i > 0; i--) {
//            if (less(a[i], a[i-1])) {
//                swap(a, i, i - 1);
//            }
//        }

        // 1.1x
        // 没效果。大概是本来就有序的几率比较小吧
        // 还没我自己写的效率高，可能是一些无效的交换吧
        int swapCount = 0;
        for (int i = N - 1; i > 0; i--) {
            if (less(a[i], a[i-1])) {
                swap(a, i, i - 1);
                swapCount++;
            }
        }
        if (swapCount == 0)
            return;

        for (int i = 1; i < N; i++) {
            // 将a[i] 插入到 a[i-1],a[i-2]... 之中
            for (int j = i; less(a[j] ,a[j - 1]); j--) {
                swap(a, j, j - 1);
            }
        }

    }

    public static void main(String[] args) {
        E02012401 sorter = new E02012401();
        Integer[] a = {1,1,13,6,4,5,6,7,8,4,3};
        sorter.sort(a);
        sorter.show(a);
    }
}
