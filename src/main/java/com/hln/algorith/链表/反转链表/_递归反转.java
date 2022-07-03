package com.hln.algorith.链表.反转链表;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * 1->2->3->4->5
 */
public class _递归反转 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        reverseBetween(node1, 3,6);
        System.out.println("");



    }

    /**
     * 部分反转 left-right
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode node = dummy;
        for(int i=1;i<left;i++){
            node = node.next;
        }
        ListNode reverseNode = node.next;
        ListNode pre=null,cur=reverseNode,next=null;
        for(int i=left;i<=right;i++){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        node.next.next = next;
        node.next = pre;

        return dummy.next;
    }

    /**
     * 递归方式反转 把递归式当作一个整体
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){
        // 递归一定有要边界
        if (head == null || head.next == null) return head;
        ListNode newNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }
}
