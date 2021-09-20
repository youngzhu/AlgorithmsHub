package com.young.algs4.ch03;

import edu.princeton.cs.algs4.In;
import org.junit.Test;

public class FrequencyCounterTest {

    FrequencyCounter frequencyCounter = new FrequencyCounter();

    In in;

    @Test
    public void testTiny() {
        in = new In("algs4/tinyTale.txt");
        frequencyCounter.count(in, 1);
    }

    @Test
    public void testTale() {
        in = new In("algs4/tale.txt");
        frequencyCounter.count(in, 8);
    }

    @Test
    public void test100K() {
        in = new In("algs4/Leipzig100K.txt");
        frequencyCounter.count(in, 10);
    }

}