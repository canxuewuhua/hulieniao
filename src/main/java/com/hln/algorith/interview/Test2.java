package com.hln.algorith.interview;

import java.util.ArrayList;
import java.util.LinkedList;

public class Test2 {

    /**
     * Java实现一个简单的hashmap
     * hash表是一个数组+链表的结构
     * 数组具有遍历快 增删慢 数组是堆中一块连续的存储空间
     * 链表具有增删快 遍历慢的特点 链表中各元素的内存空间是不连续的
     *
     *
     * 总结：hashmap其实是 动态数组+链表
     */
    static class Node{
        private Object key;
        private Object value;
        private Node next;
        public Node(){}
        public Node(Object key, Object value){
            this.key = key;
            this.value = value;
        }
    }

    private int size = 8;
    private int number = 0;
    // 哈希数组
    private ArrayList<LinkedList> arrayList = new ArrayList<>(size);
    public Test2(){
        for (int i = 0; i < size; i++) {
            LinkedList myList = new LinkedList();
            arrayList.add(myList);
        }
    }

    public Object get(Object key){
        int code = key.hashCode();
        int position = code%size;
        LinkedList list_head = arrayList.get(position);
        for (int i = 0; i < list_head.size(); i++) {
            Node head = (Node)list_head.get(i);
            Node node = head;
            while (node != null){
                if (node.key == key){
                    return node.next;
                }
                node = node.next;
            }
        }
        return null;
    }
}
