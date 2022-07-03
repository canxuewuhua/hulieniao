package com.hln.algorith.链表.链表排序;

import java.util.PriorityQueue;
import java.util.Queue;

public class NodeSort {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        deleteNode(node1, 4);
    }

    /**
     *  ========删除链表指定节点======
     * @param head
     * @param val
     * @return
     */
    public static ListNode deleteNode(ListNode head, int val) {
        if(head ==null) return null;
        if(head.val == val) return head.next;
        ListNode cur = head;
        // 解释：此处就是遇到了cur=3 它的next就为4了 此时不进行指针的移动
        // 在while循环结束后 使用if的判断将4这个node给略过
        while(cur.next !=null && cur.next.val !=val){
            cur = cur.next;
        }
        if (cur.next !=null) cur.next = cur.next.next;
        return head;
    }

    public static ListNode sortList(ListNode head) {
        Queue<ListNode> queue = new PriorityQueue<>((a, b)->a.val - b.val);
        while(head != null){
            queue.add(head);
            head = head.next;
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(queue.size()>0){
            cur.next = queue.peek();
            queue.poll();
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }
}
