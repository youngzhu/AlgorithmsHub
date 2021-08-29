package com.young.algs4.ch01;

/**
 * @author youngzy
 * @since 2021-08-29
 */
public class Stopwatch {
    private final long start;

    private long lastStart; // reset

    public Stopwatch() {
        this.start = System.currentTimeMillis();
        this.lastStart = start;
    }

    public double elapsedTimeSeconds() {
        long now = System.currentTimeMillis();
        return (now - lastStart) / 1000.0;
    }

    public double totalTimeSeconds() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

    public void reset() {
        lastStart = System.currentTimeMillis();
    }
}
