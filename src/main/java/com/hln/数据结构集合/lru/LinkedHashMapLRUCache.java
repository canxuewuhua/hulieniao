package com.hln.数据结构集合.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 使用LinkedHashMap天然能实现LRU算法
 */
public class LinkedHashMapLRUCache<K, V> extends LinkedHashMap<K, V> {

    private int capacity;//缓存坑位
    /**
     * true access-order 添加新元素的时候 存在情况下会加到链表头部
     * false insertion-order 添加新元素的时候 存在情况下元素不会变化
     * @param capacity
     */
    public LinkedHashMapLRUCache(int capacity){
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        LinkedHashMapLRUCache lruCache = new LinkedHashMapLRUCache(3);
        lruCache.put(1, "a");
        lruCache.put(2, "b");
        lruCache.put(3, "c");
        System.out.println(lruCache.keySet());
        lruCache.put(4, "d");
        System.out.println(lruCache.keySet());
        lruCache.put(3, "c");
        System.out.println(lruCache.keySet());
        lruCache.put(3, "c");
        System.out.println(lruCache.keySet());
        lruCache.put(3, "c");
        System.out.println(lruCache.keySet());
        lruCache.put(5, "e");
        System.out.println(lruCache.keySet());
    }
}
