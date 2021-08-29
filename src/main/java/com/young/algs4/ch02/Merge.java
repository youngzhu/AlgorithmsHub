package com.young.algs4.ch02;

/**
 * 归并排序的基类
 *
 * @author youngzy
 * @since 2021-08-29
 */
abstract class Merge extends SortTemplate {
    // 将两个有序数组a[lo...mid]和a[mid+1...hi]合并
    void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        // 先验条件：两个数组是有序的
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);

        // 复制到辅助数组aux[]
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        // 将归并后的数据写入a[]
        int i = lo; // 左半边起始位置
        int j = mid + 1; // 右半边起始位置
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                // 这一步可以省略
                // 但留着思路更清晰
//                a[k] = aux[j++]; // 左半边用尽，取右半边数据
                ;
            else if (j > hi)
                a[k] = aux[i++]; // 右半边用尽，取左半边数据
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++]; // 两边都有，且右边的（j）小于左边的（i），取右边的
            else
                a[k] = aux[i++]; // 其余情况都取左边
        }

        // 后验条件：合并后的数组是有序的
        assert isSorted(a, lo, hi);
    }
}
