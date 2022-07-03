package com.hln.algorith.test;

/**
 * 练习快慢指针
 */
public class QuickSlowTest {
    class Node{
        public int val;
        public Node next;
        public Node(){}
        public Node(int val){
            this.val = val;
        }
    }

    /**
     * 1、反转链表
     */
    public Node reverseNode(Node head){
        if (head == null || head.next == null) return head;
        Node pre = null,cur = head,next = null;
        while (cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 2、求链表中间节点值
     */
    public int getMiddleValue(Node head){
        if (head == null) return 0;
        Node p = head;
        Node q = head;
        while (p!=null && p.next!=null){
            p = p.next.next;
            q = q.next;
        }
        return q.val;
    }

    /**
     * 3、找到链表的倒数第n个节点
     */
    public int backN(Node head,int n){
        if (head == null) return 0;
        Node p = head;
        Node q = head;
        for (int i = 0; i < n-1; i++) {
            p = p.next;
        }
        while (p.next != null){
            p = p.next;
            q = q.next;
        }
        return q.val;
    }

    /**
     * 4、判断一个链表是否有环
     */
    public Node isLoop(Node head){
        Node p = head;
        Node q = head;
        while (p != null &&p.next!=null){
            p = p.next.next;
            q = q.next;
            if (p == q){
                return p;
            }
        }
        return null;
    }
    /**
     * 5、找到有环链表的入口
     */
    public Node entry(Node head){
        Node meet = isLoop(head);
        if (meet == null){
            return null;
        }else{
            Node p = head;
            Node q = meet;
            while (p != q){
                p = p.next;
                q = q.next;
            }
            return p;
        }
    }

    /**
     * 6、两个链表相交的点
     */
    public Node insection(Node headA, Node headB){
        Node p = headA;
        Node q = headB;
        while (p != q){
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }

    /**
     * 7、删除链表的倒数第N个节点
     */
    public Node deleteN(Node head, int n){
        Node p = head;
        Node q = head;
        for (int i = 0; i < n - 1; i++) {
            p = p.next;
        }
        if (p == null){
            return q.next;
        }
        while (p.next !=null){
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return q;
    }
}
