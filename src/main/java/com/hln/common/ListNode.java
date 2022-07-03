package com.hln.common;

/**
 * 链表节点
 * 类中变量 不写属性 默认default 包内可访问
 * private 类内可访问
 * public 都可访问
 * protected 包内和子类中可访问
 */
public class ListNode {

    public int val;
    public ListNode next;
    public ListNode(){}
    public ListNode(int val){
        this.val = val;
    }
}
