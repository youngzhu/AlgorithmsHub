package com.young.algs4.ch02;

/**
 * 三向切分的快速排序
 *
 * @author youngzy
 * @since 2021-09-04
 */
public class Quick3waySort extends QuickSort {
    /*
    从左到右遍历数组一次
    维护一个指针lt使得a[lo .. lt-1]都小于v
    一个指针gt使得a[gt+1 .. hi]都大于v
    一个指针i使得a[lt .. i-1]都等于v，a[i .. gt]不确定

    一开始i=lo+1，对a[i]进行三向比较：
    如果a[i]<v，则交换a[lt]和a[i]，lt++，i++
    如果a[i]>v，则交换a[gt]和a[i]，gt--
    如果a[i]=v，则i++
     */
    @Override
    protected void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;

        int lt = lo, gt = hi;
        Comparable v = a[lo];
        int i = lo + 1;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0)
                swap(a, lt++, i++);
            else if (cmp > 0)
                swap(a, i, gt--);
            else
                i++;
        }
        // 此时满足 a[lo..lt-1] < (v = a[lt..gt]) < a[gt+1..hi]

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
        assert isSorted(a, lo, hi);
    }
}
