package com.hln.algorith.代码随想录._2_链表;

import com.hln.common.ListNode;

public class _反转链表 {

    public static void main(String[] args) {

    }

    public ListNode reverse(ListNode head){
        ListNode pre = null, cur = head, next = null;
        while (cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
