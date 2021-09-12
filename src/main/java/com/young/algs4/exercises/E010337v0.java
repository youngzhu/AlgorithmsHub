package com.young.algs4.exercises;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 只用了一个队列，先出再进
 * 比我的辅助队列强
 */
public class E010337v0 {
    static void josephus(int N, int M) {
        Queue<Integer> queue = new Queue<>();

        for (int i = 0; i < N; i++) {
            queue.enqueue(i);
        }

        // 我去，这么简练的吗。。
        while (!queue.isEmpty()) {
            for (int i = 0; i < M - 1; i++) {
                queue.enqueue(queue.dequeue());
            }
            StdOut.print(queue.dequeue() + " ");
        }
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        int M = StdIn.readInt();

        josephus(N, M);
    }
}
