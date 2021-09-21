package com.young.algs4;

import edu.princeton.cs.algs4.In;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author youngzy
 * @since 2021-09-21
 */
public class InTest {

    // 测试 isEmpty 是否支持逐个读取数据
    @Test
    public void testIsEmptyRead1() {
        In in = new In("algs4/in1.txt");

        List<Integer> list = new ArrayList<>();
        while (! in.isEmpty()) {
            int i = in.readInt();
            list.add(i);
        }

        Integer[] expected = {1, 3, 4, 5, 9, 10};
        Assert.assertArrayEquals(expected, list.toArray(new Integer[0]));
    }

    @Test
    public void testIsEmptyRead2() {
        In in = new In("algs4/in2.txt");

        List<String> list = new ArrayList<>();
        while (! in.isEmpty()) {
            String s = in.readString();
            list.add(s);
        }

        String[] expected = {"hello", "welcome", "to", "earth"};
        Assert.assertArrayEquals(expected, list.toArray(new String[0]));
    }
}
