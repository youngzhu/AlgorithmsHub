package com.young.algs4.ch03;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

/**
 * 性能测试用例
 * 从标准输入中得到字符串，
 * 记录每个（长度至少达到指定的阈值）字符串出现的次数，
 * 然后遍历所有键并找出出现频率最高的键。
 *
 * 这个用例回答了一个简单的问题：
 * 哪个（不小于指定长度的）单词在一段文字中出现的频率最高？
 *
 * @author youngzy
 * @since 2021-09-20
 */
public class FrequencyCounter {
    public void count(In in, int minLen) {
        int distinct = 0, words = 0;

        ST<String, Integer> st = new ST<>();

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
        }

        // 找出最高频率的词
        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max))
                max = word;
        }

        StdOut.println(max + " " + st.get(max));
        StdOut.println("distinct: " + distinct);
        StdOut.println("words: " + words);
    }
}
