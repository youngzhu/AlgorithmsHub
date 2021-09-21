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
//    static VisualSequentialSearchST<String, Integer> st;
    static VisualBinarySearchST<String, Integer> st = new VisualBinarySearchST<>();

    public static void main(String[] args) {
        In in = new In("src/test/resources/algs4/tale.txt");
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

    private static class VisualBinarySearchST<K extends Comparable<K>, V> extends BinarySearchST<K, V> {

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

            int i = rank(key);

            // key 已存在
            if (i < n && keys[i].compareTo(key) == 0) {
                values[i] = value;
                return;
            }

            // key不存在，插入新的键值对
            if (n == keys.length)
                resize(2*n);

            for (int j = n; j > i; j--) {
                keys[j] = keys[j - 1];
                values[j] = values[j - 1];

                compareCounter++;
            }
            keys[i] = key;
            values[i] = value;
            n++;

        }
    }

    private static class VisualSequentialSearchST<K extends Comparable<K>, V>
            extends SequentialSearchST<K, V> {
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
