package com.hln.algorith.lovedatastruct.season03;

import com.hln.common.ListNode;

/**
 * https://leetcode-cn.com/problems/partition-list-lcci/
 *
 * 1->4->3->2->5->2->null   k = 3
 */
public class _86_分割链表 {

    public static ListNode partition(ListNode head, int k){
        if (head == null) return null;
        ListNode lHead = new ListNode(0);
        ListNode lTail = lHead;
        ListNode rHead = new ListNode(0);
        ListNode rTail = rHead;
        while (head != null){
            if (head.val < k){// 放在lTail后面
                lTail.next = head;
                lTail = head;
            }else {
                rTail.next = head;
                rTail = head;
            }
            head = head.next;
        }
        rTail.next = null;
        // 拼接
        lTail.next = rHead.next;
        return lHead.next;
    }
}
