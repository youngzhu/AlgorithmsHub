package com.young.algs4.ch02;

/**
 * 优化后的归并排序
 *
 * 优化点：
 * 1. 对小规模子数组使用插入排序
 * 2. 测试数组是否已经有序，如果有序可跳过归并
 *      a[mid] <= a[mid+1] , 有序
 * 3. 不将元素复制到辅助数组：不停地交换输入数组和辅助数组的角色
 *
 *
 * @author youngzy
 * @since 2021-08-29
 */
public class MergeSortX extends Merge {
    private static final int CUTOFF = 7; // cutoff to insertion sort

    @Override
    public void sort(Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length - 1);
    }

    private void sort(Comparable[] src, Comparable[] dst, int lo, int hi) {
//        if (hi <= lo) return;

        // 优化点2
        if (hi <= lo + CUTOFF) {
            insertionSort(dst, lo, hi);
            return;
        }

        int mid = lo + (hi - lo)/2;
        // 优化点3
        sort(dst, src, lo, mid);
        sort(dst, src, mid+1, hi);

//        if (!less(src[mid+1], src[mid])) {
//            for (int i = lo; i <= hi; i++) {
//                dst[i] = src[i];
//            }
//            return;
//        }

        // 优化点2
        if (!less(src[mid+1], src[mid])) {
            // 比上面的循环快一点
            System.arraycopy(src, lo, dst, lo, hi - lo + 1);
            return;
        }

        merge(src, dst, lo, mid, hi);
    }

    @Override
    void merge(Comparable[] src, Comparable[] dst, int lo, int mid, int hi) {
        assert isSorted(src, lo, mid);
        assert isSorted(src, mid + 1, hi);

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                dst[k] = src[j++];
            else if (j > hi) {
                dst[k] = src[i++];
            } else if (less(src[j], src[i]))
                dst[k] = src[j++];
            else
                dst[k] = src[i++];
        }

        assert isSorted(dst, lo, hi);
    }
}
