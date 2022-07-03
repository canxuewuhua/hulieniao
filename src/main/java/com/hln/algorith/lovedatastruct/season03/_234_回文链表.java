package com.hln.algorith.lovedatastruct.season03;

import com.hln.common.ListNode;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * 1->2->3->2->1  从左边和从右边的遍历是一样的 叫做回文链表
 * 有一种思路是 将链表进行反转 逐个比较 但是空间复杂度就不是O(1)了
 */
public class _234_回文链表 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

//        ListNode mid = getMiddleNode(node1);
//        ListNode rever = reverse(mid);
        isPalindrome(node1);
        System.out.println("");
    }
    public static boolean isPalindrome(ListNode head){
        if (head == null || head.next == null) return true;
        if (head.next.next == null) return head.val == head.next.val;
        ListNode mid = getMiddleNode(head);
        ListNode rHead = mid.next;
        ListNode rNode = reverse(rHead);

        ListNode lNode = head;
        while (rNode != null){
            if (lNode.val != rNode.val) return false;
            lNode = lNode.next;
            rNode = rNode.next;
        }
        return true;
    }

    private static ListNode getMiddleNode(ListNode head){
        if (head == null) return null;
        if (head.next == null || head.next.next == null) return head;
        ListNode p = head;
        ListNode q = head;
        while (p !=null &&p.next != null && p.next.next != null){
            p = p.next.next;
            q = q.next;
        }
        return q;
    }

    private static ListNode reverse(ListNode head){
        ListNode pre = null, cur = head, next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
