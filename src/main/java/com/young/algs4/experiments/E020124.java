package com.young.algs4.experiments;

import com.young.algs4.ch02.SortTemplate;

/**
 * 插入排序的哨兵
 * 在插入排序的实现中先找出最小的元素并将其置于数组的最左边，
 * 这样就能去掉内循环的判断条件j>0 .
 * 使用SortCompare来评估这种做法的效果。
 * 注意：
 * 这是一种常见的规避边界测试的方法，能够省略判断条件的元素通常被称为哨兵
 *
 * 测试结果：1.2X
 * 怎么还和参数的顺序有关呢。。
 * insertion e0124 => 1.2x
 * e0124 insertion => 1.0
 *
 * @author youngzy
 * @since 2021-10-05
 */
public class E020124 extends SortTemplate {
    @Override
    public void sort(Comparable[] a) {
        final int N = a.length;

        int min = 0; // 哨兵
        for (int i = 1; i < N; i++) {
            if (less(a[i], a[min]))
                min = i;
        }
        if (min > 0) // 这个判断基本没影响
            swap(a, 0, min);

        for (int i = 1; i < N; i++) {
            // 将a[i] 插入到 a[i-1],a[i-2]... 之中
            for (int j = i; less(a[j] ,a[j - 1]); j--) {
                swap(a, j, j - 1);
            }
        }

    }

    public static void main(String[] args) {
        E020124 sorter = new E020124();
        Integer[] a = {1,1,13,6,4,5,6,7,8,4,3};
        sorter.sort(a);
        sorter.show(a);
    }
}
