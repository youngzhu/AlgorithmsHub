package com.young.algs4.creativeproblems;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 动画
 * 修改插入排序和选择排序的代码，使之将数组内容绘制成棒状图。在每一轮排序后重绘图片来产生动画效果，
 * 并以一张"有序"的图片作为结束，即所有圆棒均以按照高度有序排列。
 *
 * 提示：使用类似正文中的用例来随机生成double值，在排序代码的适当位置调用show方法，并在show方法中清理画布并绘制棒状图
 *
 * @author youngzy
 * @since 2021-09-12
 */
public class E020117 {

    public static void main(String[] args) {
        SortShow show;
        show = new Selection();
//        show = new Insertion();
        show.sort(randomData());
    }

    static Double[] randomData() {
        int n = 20;

        Double[] a = new Double[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform();
        }

        return a;
    }

    static class Selection extends SortShow {
        @Override
        void sort(Double[] a) {
            final int N = a.length;

            for (int i = 0; i < N; i++) {
                int min = i;
                for (int j = i + 1; j < N; j++) {
                    if (less(a[j], a[min]))
                        min = j;
                }
                show(a);
                swap(a, i, min);
            }

//        show(a);
        }
    }

    static class Insertion extends SortShow {
        @Override
        void sort(Double[] a) {
            final int N = a.length;

            for (int i = 0; i < N; i++) {
                int j = i;
                for (; j > 0 && less(a[j], a[j - 1]); j--) {
                    swap(a, j, j - 1);
                }
                show(a);
            }
        }
    }

}
