package com.young.algs4.creativeproblems;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 2.1.18 可视轨迹
 * 修改上一题的代码，为插入排序和选择排序生成和正文中类似的可视轨迹
 *
 * 提示：使用setYscale()函数
 *
 * 附加题：添加必要的代码，使用红色和灰色强调不同角色的元素
 *
 * ============
 * show方法差不多，但不同颜色对应的含义不一样
 *
 * @author youngzy
 * @since 2021-09-12
 */
public class E020118 {

    public static void main(String[] args) {
        Double[] a = randomData();

        StdDraw.setYscale(0, a.length);

//        new Selection().sort(a);
        new Insertion().sort(a);
    }

    static Double[] randomData() {
        int n = 15;

        Double[] a = new Double[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform();
        }

        return a;
    }

    private static abstract class Base {
        abstract void sort(Double[] a);

        boolean less(Double v1, Double v2) {
            return v1.compareTo(v2) < 0;
        }

        void swap(Double[] a, int idxI, int idxJ) {
            Double t = a[idxI];
            a[idxI] = a[idxJ];
            a[idxJ] = t;
        }
    }

    private static class Selection extends Base {
        @Override
        void sort(Double[] a) {
            final int N = a.length;

            for (int i = 0; i < N; i++) {
                int min = i;
                for (int j = i + 1; j < N; j++) {
                    if (less(a[j], a[min]))
                        min = j;
                }
                show(i, a, min);
                swap(a, i, min);
            }

//        show(a);
        }

        void show(int round, Double[] a, int min) {
            int n = a.length;

            for (int i = 0; i < n; i++) {
                double x = 0.5 * (2 * i + 1) / n;
                double y = a[i] / 2.0 + (n - round - 1);
                double rw = 0.5 / n;
                double rh = a[i] / 2.0;

                // 选择排序就是在黑色的元素中查找最小值
                if (i == min) // a[min]，也是剩下的元素中最小的元素
                    StdDraw.setPenColor(StdDraw.BOOK_RED);
                else if (i < round) // 已经排好序的元素
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                else // 剩余未排序的元素
                    StdDraw.setPenColor(StdDraw.BLACK);

                StdDraw.filledRectangle(x, y, rw, rh);
                StdDraw.pause(100);
            }
        }
    }

    private static class Insertion extends Base {
        @Override
        void sort(Double[] a) {
            final int N = a.length;

            for (int i = 0; i < N; i++) {
                int j = i;
                for (; j > 0 && less(a[j], a[j - 1]); j--) {
                    swap(a, j, j - 1);
                }
                show(i, a, j);
            }
        }

        void show(int round, Double[] a, int jth) {
            int n = a.length;

            for (int i = 0; i < n; i++) {
                double x = 0.5 * (2 * i + 1) / n;
                double y = a[i] / 2.0 + (n - round - 1);
                double rw = 0.5 / n;
                double rh = a[i] / 2.0;

                if (i == jth) // 移动的元素 a[j]
                    StdDraw.setPenColor(StdDraw.BOOK_RED);
                else if (i > round) // 灰色的元素，不会移动
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                else if (i < jth) // 灰色的元素，不会移动
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                else // 黑色的元素向后移动了一格
                    StdDraw.setPenColor(StdDraw.BLACK);

                StdDraw.filledRectangle(x, y, rw, rh);
                StdDraw.pause(100);
            }
        }
    }

}
