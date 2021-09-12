package com.young.algs4.ch01;

import edu.princeton.cs.algs4.StdDraw;

/**
 * @author youngzy
 * @since 2021-09-12
 */
// 测试结束，窗口就关了。所以用main
public class StdDrawTest {

    public static void main(String[] args) {
        testFilledRectangle();
    }

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
}
