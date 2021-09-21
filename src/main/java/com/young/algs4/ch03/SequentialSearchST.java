package com.young.algs4.ch03;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * 顺序查找（基于无序列表）
 *
 * @author youngzy
 * @since 2021-09-20
 */
public class SequentialSearchST<K extends Comparable<K>, V>
        extends AbstractST<K, V> {

    Node first;

    class Node {
        K key;
        V value;
        Node next;

        Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public V get(K key) {
        if (key == null)
            throw new IllegalArgumentException("key is null");
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key))
                return x.value;
        }
        return null;
    }

    public void put(K key, V value) {
        if (key == null)
            throw new IllegalArgumentException("key is null");

        if (value == null) {
            delete(key);
            return;
        }

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
        n++;
    }

    public void delete(K key) {
        if (key == null)
            throw new IllegalArgumentException("key is null");
        first = delete(first, key);
    }

    // delete key in linked list beginning at Node x
    // warning: function call stack too large if table is large
    private Node delete(Node x, K key) {
        if (x == null)
            return null;
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public Iterable<K> keys() {
        Queue<K> queue = new Queue<>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }

    public static void main(String[] args) {
        String input = "SEARCHEXAMPLE";

        SequentialSearchST<Character, Integer> st = new SequentialSearchST<>();
        char[] arr = input.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            st.put(arr[i], i);
        }

        for (Character c : st.keys())
            StdOut.println(c + " " + st.get(c));
    }
}
