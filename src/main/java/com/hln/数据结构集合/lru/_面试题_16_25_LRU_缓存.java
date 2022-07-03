package com.hln.数据结构集合.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表+链表实现
 * get方法 put方法
 */
public class _面试题_16_25_LRU_缓存 {

    class Node<K, V>{
        K key;
        V value;
        Node<K, V> next;
        Node<K, V> prev;
        Node(){
            this.next = this.prev = null;
        }
        Node(K key, V value){
            this.key = key;
            this.value = value;
            this.next = this.prev = null;
        }
    }

    class DoubleLinkedList<K, V>{
        Node<K, V> head;
        Node<K, V> tail;
        DoubleLinkedList(){
            head = new Node<>();
            tail = new Node<>();
            // 初始化
            head.next = tail;
            tail.prev = head;
        }

        // 双向链表插入节点
        public void addNode(Node<K, V> node){
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }
        // 双向链表删除节点
        public void removeNode(Node<K, V> node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.prev = null;
            node.next = null;

        }

        public Node getLast(){
            return tail.prev;
        }
    }

    private int capacity;
    private Map<Integer, Node<Integer, Integer>> map;
    private DoubleLinkedList<Integer, Integer> doubleLinkedList;

    public _面试题_16_25_LRU_缓存(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList<>();
    }

    public int get(int key){
        if(!map.containsKey(key)) return -1;
        Node<Integer, Integer> node = map.get(key);
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addNode(node);
        return node.value;
    }

    public void put(int key, int value){
        if (map.containsKey(key)){
            // update
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key, node);
            doubleLinkedList.removeNode(node);
            doubleLinkedList.addNode(node);
        }else {
            if (map.size() == capacity){
                // 移除最后一个节点 添加新节点到队头
                Node last = doubleLinkedList.getLast();
                map.remove(last.key);
                doubleLinkedList.removeNode(last);
            }
            Node<Integer, Integer> newNode = new Node<>(key, value);
            map.put(key, newNode);
            doubleLinkedList.addNode(newNode);
        }
    }

}
