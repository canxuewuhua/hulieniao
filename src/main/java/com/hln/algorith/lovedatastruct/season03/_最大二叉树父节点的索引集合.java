package com.hln.algorith.lovedatastruct.season03;

import com.hln.common.ListNode;

public class _最大二叉树父节点的索引集合 {

    /**
     * 求链表的中间节点
     */
    public static ListNode getMid(ListNode head){
        if (head == null) return null;
        ListNode p = head;
        ListNode q = head;
        while (head.next != null){
            p = p.next.next;
            q = q.next;
        }
        return q;
    }
}
