package com.young.algs4.experiments;

import com.young.algs4.ch02.InsertionSort;

/**
 * 不需要交换的插入排序
 * 在插入排序的实现中使较大元素右移一位只需要访问一次数组，而不使用交换。
 *
 * 使用SortCompare来评估这种做法的效果
 *
 * 测试结果：
 * e0125 insertion => 1.2-1.3
 * insertion e0125 => 1.6-1.9
 *
 * @author youngzy
 * @since 2021-10-05
 */
public class E020125 extends InsertionSort {
    @Override
    public void sort(Comparable[] a) {
        final int N = a.length;

        for (int i = 1; i < N; i++) {
            Comparable t = a[i];
            int j = i;
            // 比 t 大的，右移一位（而不是交换）
            while (j > 0 && less(t, a[j - 1])) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = t;
        }

    }

    public static void main(String[] args) {
        E020125 sorter = new E020125();
        Integer[] a = {1,1,13,6,4,5,6,7,8,4,3};
        sorter.sort(a);
        sorter.show(a);
    }
}
