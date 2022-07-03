package com.hln.algorith.链表.合并有序链表;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/vvXgSW/
 * 给定一个链表数组，每个链表都已经按升序排列。
 *
 * 请将所有链表合并到一个升序链表中，返回合并后的链表。
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 *
 */
public class _剑指OfferII_078_合并排序链表 {

     public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>((a,b)->a.val-b.val);
        for (ListNode node : lists){
            if (node !=null) queue.offer(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(queue.size()>0){
            ListNode p = queue.poll();
            cur.next = p;
            if (p.next !=null) queue.offer(p.next);
            cur = p;
            cur.next = null;
        }
        return dummy;
    }

    public static ListNode sortList(ListNode head) {
        Queue<ListNode> queue = new PriorityQueue<>((a,b)->a.val - b.val);
        while(head !=null){
            queue.offer(head);
            head = head.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(queue.size()>0){
            cur.next = queue.poll();
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;

        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);
        node7.next = node8;


        sortList(node1);
    }
}
