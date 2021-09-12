package com.young.algs4.exercises;

import com.young.algs4.ch01.ThreeSumFast;
import edu.princeton.cs.algs4.*;

/**
 * 练习1.4.3
 * 修改DoublingTest，使用StdDraw画出图像
 * 根据需要调整比例，使得图像总能够充满窗口的大部分区域
 *
 * @author youngzy
 * @since 2021-08-21
 */
public class E010403 {
    private static final int MAX_INTEGER = 1_000_000;

    E010403(double xScale, double yScale) {
        StdDraw.setXscale(0, xScale);
        StdDraw.setYscale(0, yScale);
    }

    static double timeTrial(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(-MAX_INTEGER, MAX_INTEGER);
        }
        Stopwatch timer = new Stopwatch();
//        ThreeSum.count(a);
        ThreeSumFast.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        int maxN = 8000;
        Stack<Integer> xStack = new Stack<>();
        Stack<Double> yStack = new Stack<>();

        for (int n = 250; n <= maxN; n += n) {
            double time = timeTrial(n);
//            StdOut.printf("%7d %7.1f\n", n, time);
            xStack.push(n);
            yStack.push(time);
        }

        double xMax = xStack.peek() * 1.1;
        double yMax = yStack.peek() * 1.1;
        E010403 image = new E010403(xMax, yMax);

        while (xStack.size() > 1) {
            double x = xStack.pop();
            double y = yStack.pop();
            StdDraw.setPenRadius(.01);
            StdDraw.point(x, y);
            StdDraw.setPenRadius(.005);
            StdDraw.line(x, y, xStack.peek(), yStack.peek());
        }
    }
}
