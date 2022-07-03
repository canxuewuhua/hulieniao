package com.hln.algorith;

import com.hln.common.ListNode;

public class ListNodeReverse {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        ListNode newNode = reverse(node1);
        System.out.println("");
    }

    /**
     * pre 前指针  cur当前指针 next 下一个指针
     * next记录当前指针的下一个节点
     * 然后用cur.next进行记录pre 进行移动指针
     * cur再被赋值为之前记录的next节点
     */
    public static ListNode reverse(ListNode root){
        ListNode pre = null, cur = root, next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public static ListNode reverse1(ListNode root){
        if (root == null || root.next == null) return root;
        ListNode newHead = reverse1(root.next);
        root.next.next = newHead;
        root.next = null;
        return newHead;
    }

    /**
     * 跟reverse解法一致
     * @param root
     * @return
     */
    public static ListNode reverse2(ListNode root){
        if (root == null) return root;
        ListNode newHead = null;
        while (root!=null){
            ListNode temp = root.next;
            root.next = newHead;
            newHead = root;
            root = temp;
        }
        return newHead;
    }
}
