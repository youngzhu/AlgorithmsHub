package com.young.algs4.ch03;

import com.young.algs4.ch01.VisualAccumulator;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

/**
 * 可视化的词频计数器
 * <p>
 * 跑得机器呼呼的。。
 *
 * @author youngzy
 * @since 2021-09-21
 */
public class VisualFrequencyCounter {
    static VisualSequentialSearchST<String, Integer> st;

    public static void main(String[] args) {
        In in = new In("src/test/resources/algs4/tale.txt");
        st = new VisualSequentialSearchST<String, Integer>();
        count(in, 8);
    }

    static void count(In in, int minLen) {
        int distinct = 0, words = 0;

        List<Integer> compareCounterPerPut = new ArrayList<>(); // 每次put的比较次数

        // 计算频率
        while (!in.isEmpty()) {
            String key = in.readString();
            if (key.length() < minLen)
                continue;
            words++;
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            } else {
                st.put(key, 1);
                distinct++;
            }
            compareCounterPerPut.add(st.compareCounter);
        }

        VisualAccumulator accumulator = new VisualAccumulator(words, distinct);
        for (Integer compareCounter : compareCounterPerPut) {
            accumulator.addDataValue(compareCounter);
        }

        StdOut.println("X(words/puts): " + words);
        StdOut.println("Y(keys): " + distinct);
    }

    private static class VisualSequentialSearchST<K, V> extends SequentialSearchST<K, V> {
        int compareCounter;

        @Override
        public void put(K key, V value) {
            if (key == null)
                throw new IllegalArgumentException("key is null");

            if (value == null) {
                delete(key);
                return;
            }

            compareCounter = 1;
            for (Node x = first; x != null; x = x.next) {
                if (key.equals(x.key)) {
                    x.value = value;
                    return;
                }
                compareCounter++;
            }
            first = new Node(key, value, first);
            n++;
        }
    }
}
