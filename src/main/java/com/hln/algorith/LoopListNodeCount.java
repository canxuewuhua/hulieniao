package com.hln.algorith;

import com.hln.common.ListNode;

public class LoopListNodeCount {
    /**
     * 遍历ListNode 统计链表的长度
     * 指针后移 进行统计
     */

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        int total = 0;
        ListNode cur = node1;
        while (cur != null){
            cur = cur.next;
            total++;
        }
        System.out.println(total);
    }
}
