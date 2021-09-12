package com.young.algs4.exercises;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 约瑟夫环
 *
 * @author youngzy
 * @since 2021-08-21
 */
public class E010337 {
    static void josephus(int N, int M) {
        Queue<Integer> queue = new Queue<>();
        Queue<Integer> helper = new Queue<>();
        Queue<Integer> result = new Queue<>();

        for (int i = 0; i < N; i++) {
            queue.enqueue(i);
        }

        int count = 0;
        while (true) {
            if (queue.isEmpty())
                break;

            while (!queue.isEmpty()) {
                int no = queue.dequeue();
                count ++;
                if (count == M) {
                    result.enqueue(no); // 出局
                    count = 0; // 重置
                } else {
                    // 进入下一轮
                    helper.enqueue(no);
                }
            }

            while (! helper.isEmpty()) {
                queue.enqueue(helper.dequeue());
            }
        }

        StdOut.println(result);
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        int M = StdIn.readInt();

        josephus(N, M);
    }
}
