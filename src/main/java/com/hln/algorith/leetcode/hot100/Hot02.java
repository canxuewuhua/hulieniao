package com.hln.algorith.leetcode.hot100;

import com.hln.common.ListNode;

/**
 * 两数之和
 */
public class Hot02 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;
        addTwoNumbers(node1, node4);
        System.out.println("");
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1!=null || l2!=null){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y +carry;
            carry = sum/10;
            sum = sum%10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (l1!=null){
                l1 = l1.next;
            }

            if (l2!=null){
                l2 = l2.next;
            }
        }
        if (carry == 1){
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}
