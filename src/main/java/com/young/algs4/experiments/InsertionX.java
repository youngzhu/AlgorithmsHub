package com.young.algs4.experiments;

import com.young.algs4.ch02.InsertionSort;

/**
 * 插入排序（优化版）
 * 优化点：
 * 1 设置哨兵（E020124）
 * 2 不做交换（E020125）
 *
 * 测试结果：
 * insertionx insertion => 1.1-1.2
 * insertion insertionx => 1.3
 *
 * 双优比单优效果差，不理解！！！
 *
 * @author youngzy
 * @since 2021-10-05
 */
public class InsertionX extends InsertionSort {
    @Override
    public void sort(Comparable[] a) {
        final int N = a.length;

        // 循环导致拖慢了效率？？
        int min = 0; // 哨兵
        for (int i = 1; i < N; i++) {
            if (less(a[i], a[min]))
                min = i;
        }
        if (min > 0) // 这个判断基本没影响
            swap(a, 0, min);

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
        InsertionX sorter = new InsertionX();
        Integer[] a = {1,1,13,6,4,5,6,7,8,4,3};
        sorter.sort(a);
        sorter.show(a);
    }
}
