package com.young.algs4.ch03;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

/**
 * 二分查找（基于有序数组）
 *
 * @author youngzy
 * @since 2021-09-21
 */
public class BinarySearchST<K extends Comparable<K>, V>
        extends AbstractST<K, V> {
    static final int INIT_CAPACITY = 2;

    K[] keys;
    V[] values;

    public BinarySearchST() {
        this(INIT_CAPACITY);
    }

    public BinarySearchST(int capacity) {
        keys = (K[]) new Comparable[capacity];
        values = (V[]) new Object[capacity];
    }

    private void resize(int capacity) {
        assert capacity >= n;

        K[] tempK = (K[]) new Comparable[capacity];
        V[] tempV = (V[]) new Object[capacity];

        for (int i = 0; i < n; i++) {
            tempK[i] = keys[i];
            tempV[i] = values[i];
        }

        keys = tempK;
        values = tempV;
    }

    @Override
    public V get(K key) {
        if (key == null)
            throw new IllegalArgumentException("key is null");
        if (isEmpty())
            return null;

        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0)
            return values[i];

        return null;
    }

    public int rank(K key) {
        if (key == null)
            throw new IllegalArgumentException("key is null");

        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp == 0)
                return mid;
            else if (cmp < 0)
                hi = mid - 1;
            else
                lo = mid + 1;
        }

        return lo;
    }

    public void put(K key, V value) {
        if (key == null)
            throw new IllegalArgumentException("key is null");

        if (value == null) {
            delete(key);
            return;
        }

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
        }
        keys[i] = key;
        values[i] = value;
        n++;

        assert check();
    }

    public void delete(K key) {
        if (key == null)
            throw new IllegalArgumentException("key is null");
        if (isEmpty())
            return;

        int i = rank(key);

        // key not in table
        if (i == n || keys[i].compareTo(key) != 0)
            return;

        for (int j = i; j < n - 1; j++) {
            keys[j] = keys[j+1];
            values[j] = values[j+1];
        }

        n--;

        // to avoid loitering
        keys[n] = null;
        values[n] = null;

        // resize if 1/4 full
        if (n > 0 && n == keys.length/4)
            resize(keys.length / 2);

        assert check();
    }

    public void deleteMin() {
        if (isEmpty())
            throw new NoSuchElementException("Symbol table is empty");
        delete(min());
    }

    public void deleteMax() {
        if (isEmpty())
            throw new NoSuchElementException("Symbol table is empty");
        delete(max());
    }

    //**********
    // Ordered symbol table methods
    //**********

    public K min() {
        if (isEmpty())
            throw new NoSuchElementException("Symbol table is empty");
        return keys[0];
    }

    public K max() {
        if (isEmpty())
            throw new NoSuchElementException("Symbol table is empty");
        return keys[n-1];
    }

    /**
     * Return the kth smallest key in this symbol table
     *
     * @param k
     * @return
     */
    public K select(int k) {
        if (k < 0 || k >= size())
            throw new IllegalArgumentException("Out of range: " + k);
        return keys[k];
    }

    public Iterable<K> keys() {
        return keys(min(), max());
    }

    public Iterable<K> keys(K lo, K hi) {
        if (lo == null)
            throw new IllegalArgumentException("1st Key is null");
        if (hi == null)
            throw new IllegalArgumentException("2nd Key is null");

        Queue<K> queue = new Queue<>();
        if (lo.compareTo(hi) > 0)
            return queue;
        for (int i = rank(lo); i < rank(hi); i++)
            queue.enqueue(keys[i]);
        if (contains(hi))
            queue.enqueue(keys[rank(hi)]);
        return queue;
    }

    //**********
    // Check internal invariants
    //**********

    private boolean check() {
        return isSorted() && rankCheck();
    }

    // are the items in the array in ascending order?
    private boolean isSorted() {
        for (int i = 1; i < size(); i++) {
            if (keys[i].compareTo(keys[i-1]) < 0)
                return false;
        }
        return true;
    }

    // check that rank(select(i)) = i
    private boolean rankCheck() {
        for (int i = 0; i < size(); i++) {
            if (i != rank(select(i)))
                return false;
        }
        for (int i = 0; i < size(); i++) {
            if (keys[i].compareTo(select(rank(keys[i]))) != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "SEARCHEXAMPLE";

        BinarySearchST<Character, Integer> st = new BinarySearchST<>();
        char[] arr = input.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            st.put(arr[i], i);
        }

        for (Character c : st.keys())
            StdOut.println(c + " " + st.get(c));
    }
}
