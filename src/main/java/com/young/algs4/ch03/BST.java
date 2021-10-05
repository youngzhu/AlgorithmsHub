package com.young.algs4.ch03;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

/**
 * 二叉查找树
 *
 * @author youngzy
 * @since 2021-10-04
 */
public class BST<K extends Comparable<K>, V> {
    private Node root; // root of BST

    private class Node {
        private K key; // sorted by key
        private V val; // associated data
        private Node left, right; // left and right subtrees
        private int size; // 以该节点为根的子树中的节点总数

        Node(K key, V val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null)
            return 0;
        return x.size;
    }

    public boolean contains(K key) {
        if (key == null)
            throw new IllegalArgumentException("Key is null");
        return get(key) != null;
    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node x, K key) {
        if (key == null)
            throw new IllegalArgumentException("Key is null");
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return get(x.left, key);
        else if (cmp > 0)
            return get(x.right, key);
        else
            return x.val;
    }

    public void put(K key, V val) {
        if (key == null)
            throw new IllegalArgumentException("calls put() with a null key");
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
        assert check();
    }

    private Node put(Node x, K key, V val) {
        if (x == null)
            return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, val);
        else if (cmp > 0)
            x.right = put(x.right, key, val);
        else
            x.val = val;

        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void deleteMin() {
        if (isEmpty())
            throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
        assert check();
    }

    private Node deleteMin(Node x) {
        if (x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax() {
        if (isEmpty())
            throw new NoSuchElementException("Symbol table underflow");
        root = deleteMax(root);
        assert check();
    }

    private Node deleteMax(Node x) {
        if (x.right == null)
            return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * Removes the specified key and its associated value
     * from this symbol table (if the key is in this symbol table)
     *
     * @param key
     */
    public void delete(K key) {
        if (key == null)
            throw new IllegalArgumentException("calls delete() with a null key");
        root = delete(root, key);
        assert check();
    }

    private Node delete(Node x, K key) {
        if (x == null)
            return null;

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = delete(x.left, key);
        else if (cmp > 0)
            x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public K min() {
        if (isEmpty())
            throw new NoSuchElementException("calls min() with empty symbol table");
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null)
            return x;
        else
            return min(x.left);
    }

    public K max() {
        if (isEmpty())
            throw new NoSuchElementException("calls max() with empty symbol table");
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null)
            return x;
        else
            return max(x.right);
    }

    /**
     * Returns the largest key in the symbol table less than or equals to key
     *
     * @param key
     * @return
     */
    public K floor(K key) {
        if (key == null)
            throw new IllegalArgumentException("arg to floor() is null");
        if (isEmpty())
            throw new NoSuchElementException("calls floor() with empty ST");

        Node x = floor(root, key);
        if (x == null)
            throw new NoSuchElementException("arg to floor() is too small");
        else
            return x.key;
    }

    private Node floor(Node x, K key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null)
            return t;
        else
            return x;
    }

    // 跟floor基本一样的
    // best参数的处理和floor中 if(t!=null) 相同的逻辑
    public K floor2(K key) {
        K x = floor2(root, key, null);
        if (x == null)
            throw new NoSuchElementException("arg to floor2() is too small");
        else
            return x;
    }

    private K floor2(Node x, K key, K best) {
        if (x == null)
            return best;

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return floor2(x.left, key, best);
        else if (cmp > 0)
            return floor2(x.right, key, x.key);
        else
            return x.key;
    }

    /**
     * Returns the smallest key in the symbol table
     * greater than or equal to key
     *
     * @param key
     * @return
     */
    public K ceiling(K key) {
        if (key == null)
            throw new IllegalArgumentException("arg to ceiling() is null");
        if (isEmpty())
            throw new NoSuchElementException("calls ceiling() with empty ST");

        Node x = ceiling(root, key);
        if (x == null)
            throw new NoSuchElementException("arg to ceiling() is too large");
        else
            return x.key;
    }

    private Node ceiling(Node x, K key) {
        if (x == null)
            return null;

        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            return x;
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null)
                return t;
            else
                return x;
        }
        return ceiling(x.right, key);
    }

    /**
     * Return the key in the ST of given rank.
     * This key has the property that there are rank keys in
     * the ST that are smaller.
     * In other words, this key is the (rank+1)st smallest key in the ST
     *
     * @param rank
     * @return
     */
    public K select(int rank) {
        if (rank < 0 || rank >= size()) {
            throw new IllegalArgumentException("arg to select() is invalid: " + rank);
        }
        return select(root, rank);
    }

    // Return key in BST rooted at x of given rank.
    // Precondition: rank is in legal range.
    private K select(Node x, int rank) {
        if (x == null)
            return null;
        int leftSize = size(x.left);
        if (leftSize > rank)
            return select(x.left, rank);
        else if (leftSize < rank)
            return select(x.right, rank - leftSize - 1);
        else
            return x.key;
    }

    /**
     * Return the number of keys in the ST strictly less than key
     *
     * @param key
     * @return
     */
    public int rank(K key) {
        if (key == null)
            throw new IllegalArgumentException("arg to rank() is null");
        return rank(key, root);
    }

    // Number of keys in the subtree less than key
    private int rank(K key, Node x) {
        if (x == null)
            return 0;

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return rank(key, x.left);
        else if (cmp > 0)
            return 1 + size(x.left) + rank(key, x.right);
        else
            return size(x.left);
    }

    /**
     * Returns all keys in the ST as an Iterable.
     * To iterate over all of the keys in the ST,
     * use the foreach notation:
     *      for (K key : st.keys())
     *
     * @return
     */
    public Iterable<K> keys() {
        if (isEmpty())
            return new Queue<>();
        return keys(min(), max());
    }

    /**
     * Return all keys in the ST in the given range
     * @param lo
     * @param hi
     * @return
     */
    public Iterable<K> keys(K lo, K hi) {
        if (lo == null)
            throw new IllegalArgumentException("first arg to keys() is null");
        if (hi == null)
            throw new IllegalArgumentException("second arg to keys is null");

        Queue<K> queue = new Queue<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<K> queue, K lo, K hi) {
        if (x == null)
            return;

        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);

        if (cmplo < 0)
            keys(x.left, queue, lo, hi);
        if (cmplo <=0 && cmphi >= 0)
            queue.enqueue(x.key);
        if (cmphi > 0)
            keys(x.right, queue, lo, hi);
    }

    /**
     * Return the number of keys in the ST in the given range
     *
     * @param lo
     * @param hi
     * @return
     */
    public int size(K lo, K hi) {
        if (lo == null)
            throw new IllegalArgumentException("1st arg to size() is null");
        if (hi == null)
            throw new IllegalArgumentException("2nd arg to size() is null");

        if (lo.compareTo(hi) > 0)
            return 0;
        if (contains(hi))
            return rank(hi) - rank(lo) + 1;
        else
            return rank(hi) - rank(lo);
    }

    /**
     * Return the height of the BST (for debugging)
     *
     * @return
     */
    public int height() {
        return height(root);
    }
    private int height(Node x) {
        if (x == null)
            return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    /**
     * Return the keys in the BST in level order (for debugging)
     *
     * @return
     */
    public Iterable<K> levelOrder() {
        Queue<K> keys = new Queue<>();
        Queue<Node> queue = new Queue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node x = queue.dequeue();
            if (x == null)
                continue;
            keys.enqueue(x.key);
            queue.enqueue(x.left);
            queue.enqueue(x.right);
        }
        return keys;
    }

    /*****************************************************************
     Check integrity of BST data structure
     *****************************************************************/

    private boolean check() {
        if (!isBST())
            StdOut.println("Not in symmetric order");
        if (!isSizeConsistent())
            StdOut.println("Subtree counts not consistent");
        if (!isRankConsistent())
            StdOut.println("Ranks not consistent");
        return isBST() && isSizeConsistent() && isRankConsistent();
    }

    // does this binary tree staisfy symmetric order?
    // Note: this test also ensures that data structures is
    // a binary tree since order is strict
    private boolean isBST() {
        return isBST(root, null, null);
    }

    // is the tree rooted at x a BST with all keys strictly
    // between min and max
    // (if min or max is null, treat as empty constraint)
    // Credit: Bob Dondero's elegant solution
    private boolean isBST(Node x, K min, K max) {
        if (x == null)
            return true;
        if (min != null && x.key.compareTo(min) <= 0)
            return false;
        if (max != null && x.key.compareTo(max) >= 0)
            return false;
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    }

    // are the size fields correct?
    private boolean isSizeConsistent() {
        return isSizeConsistent(root);
    }
    private boolean isSizeConsistent(Node x) {
        if (x == null)
            return true;
        if (x.size != size(x.left) + size(x.right) + 1)
            return false;
        return isSizeConsistent(x.left) && isSizeConsistent(x.right);
    }

    // check that ranks are consistent
    private boolean isRankConsistent() {
        for (int i = 0; i < size(); i++) {
            if (i != rank(select(i)))
                return false;
        }

        for (K key : keys()) {
            if (key.compareTo(select(rank(key))) != 0)
                return false;
        }

        return true;
    }

    /**
     * Unit tests
     *
     * @param args
     */
    public static void main(String[] args) {
        BST<String, Integer> st = new BST<>();

        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        for (String s : st.levelOrder())
            StdOut.println(s + " " + st.get(s));

        StdOut.println();

        for (String key : st.keys())
            StdOut.println(key + " " + st.get(key));
    }
}
