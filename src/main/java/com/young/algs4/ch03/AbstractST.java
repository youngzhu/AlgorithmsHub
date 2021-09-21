package com.young.algs4.ch03;

/**
 * @author youngzy
 * @since 2021-09-21
 */
abstract class AbstractST<K extends Comparable<K>, V> {
    int n; // 键值对的数量

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(K key) {
        if (key == null)
            throw new IllegalArgumentException("key is null");
        return get(key) != null;
    }

    public abstract V get(K key);

    /**
     * 如果key已存在，则更新旧值
     * 如果不存在，则添加
     *
     * 如果value=null，则删除这个key值
     *
     * @param key
     * @param value
     */
    public abstract void put(K key, V value);
}
