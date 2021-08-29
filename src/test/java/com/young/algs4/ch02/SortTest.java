package com.young.algs4.ch02;

import edu.princeton.cs.algs4.In;
import org.junit.Before;
import org.junit.Test;

public class SortTest {
    In in;

    @Before
    public void init() {
        in = new In("algs4/tiny.txt");
    }

    @Test
    public void testSelection() {
        test(new SelectionSort());
    }

    @Test
    public void testInsertion() {
        test(new InsertionSort());
    }

    @Test
    public void testShell() {
        test(new ShellSort());
    }

    @Test
    public void testMerge() {
        test(new MergeSort());
    }

    private void test(SortTemplate sorter) {
        sorter.execute(in.readAllStrings());
    }
}