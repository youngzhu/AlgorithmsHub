package com.young.algs4.ch01;

import edu.princeton.cs.algs4.StdDraw;

/**
 * @author youngzy
 * @since 2021-09-12
 */
// 测试结束，窗口就关了。所以用main
public class StdDrawTest {

    public static void main(String[] args) {
//        testFilledRectangle();
        testSetYscale();
    }

    // 画柱状图
    static void testFilledRectangle() {
        double[] a = {0.5, 1};
        int n = a.length;

//        StdDraw.setXscale(-.1, 1);
        for (int i = 0; i < n; i++) {
            double x = 0.5 * (2 * i + 1) / n;
            double y = a[i] / 2.0;
            double halfWidth = 0.5 / n;
            double halfHeight = a[i] / 2.0;
            StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
        }
    }

    // 多层数据
    static void testSetYscale() {

        StdDraw.setYscale(0, 2);
        double[] a1 = {0.5, 0.8};
        int n = a1.length;
        for (int i = 0; i < n; i++) {
            double x = 0.5 * (2 * i + 1) / n;
            double y = a1[i] / 2.0 + (n-1);
            double halfWidth = 0.5 / n;
            double halfHeight = a1[i] / 2.0;
            StdDraw.pause(3000);
            StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
        }

        StdDraw.setPenColor(StdDraw.RED);
        double[] a2 = {0.1, 0.3};
        n = a1.length;
        for (int i = 0; i < n; i++) {
            double x = 0.5 * (2 * i + 1) / n;
            double y = a1[i] / 2.0 + n - 2;
            double halfWidth = 0.5 / n;
            double halfHeight = a1[i] / 2.0;
            StdDraw.pause(1000);
            StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
        }
    }
}
