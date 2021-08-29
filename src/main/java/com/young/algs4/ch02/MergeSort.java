package com.young.algs4.ch02;

/**
 * 自顶向下的归并排序
 *
 * @author youngzy
 * @since 2021-08-29
 */
public class MergeSort extends SortTemplate {
    @Override
    public void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length]; // 辅助数组
        sort(a, aux, 0, a.length - 1);
    }

    // 对数组a[lo...hi]归并排序
    private void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;

        int mid = lo + (hi - lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    // 将两个有序数组a[lo...mid]和a[mid+1...hi]合并
    private void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
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
                a[k] = aux[j++]; // 左半边用尽，取右半边数据
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
