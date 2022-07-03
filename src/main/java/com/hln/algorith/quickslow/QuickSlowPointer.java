package com.hln.algorith.quickslow;

import com.hln.common.ListNode;

import java.util.*;

/**
 * 快慢指针解决问题
 */
public class QuickSlowPointer {

    public static void main(String[] args) {
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(5);
//        ListNode node5 = new ListNode(8);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        deleteNode(node1, 2);
isLoopBySet();
    }

    public static boolean isLoopBySet(){
        Set<String> set = new HashSet<>();
        set.add("4");
        System.out.println(set.add("4"));
        System.out.println(set.size());
        List<String> list = new ArrayList<>();
        list.add("zhang");
        System.out.println(list.add("zhang"));
        System.out.println(list.size());
        Map<String,String> map = new HashMap<>();
        map.put("zhangsan","zhangsan");
        map.put("zhangsan","zhangsan");
        System.out.println(map.size());
        return true;
    }

    /**
     * 1、求链表中间节点值 一个指针走两步 一个指针走一步，走两步的结束了，走一步的就正好到中间
     * 如果是偶数个节点 中间值有两个 想返回第一个
     */
    public static int getMiddleNode(ListNode head){
        if (head == null) return 0;
        if (head.next == null || head.next.next == null) return head.val;
        ListNode p = head;
        ListNode q = head;
        while (p != null && p.next != null && p.next.next != null){
            p = p.next.next;
            q = q.next;
        }
        return q.val;
    }

    /**
     * 如果是偶数个节点 中间值有两个 想返回第二个
     * @param head
     * @return
     */
    public static int getMiddleNode1(ListNode head){
        if (head == null) return 0;
        ListNode p = head;
        ListNode q = head;
        while(p != null && p.next != null){
            p = p.next.next;
            q = q.next;
        }
        return q.val;

    }

    /**
     * 2、找到链表的倒数第n个节点
     */
    public static int getBackN(ListNode head,int n){
        ListNode p = head;
        ListNode q = head;
        for (int i=0; i<n-1; i++){
            p = p.next;
        }
        while (p.next != null){
            p = p.next;
            q = q.next;
        }
        return q.val;
    }

    /**
     * 3、判断一个链表是否有环 有环可以一直next
     * 一个走两步 一个走一步 肯定会相交
     */
    public static ListNode isLoop(ListNode head){
        ListNode p = head;
        ListNode q = head;
        while (p!=null && p.next!=null){
            p = p.next.next;
            q = q.next;
            if (p == q){
                return p;
            }
        }
        return null;
    }

    /**
     *  4、找到有环链表的入口
     *  相遇后，如果在链表头和相遇点各设置一个指针，每次走一步，两指针必定相遇，且在相遇第一个点为环入口。
     */
    public static ListNode entryMyNode(ListNode root){
        ListNode meet = isLoop(root);
        if (meet == null){
            return null;
        }else{
            ListNode p = root;
            ListNode q = meet;
            while (p != q){
                p = p.next;
                q = q.next;
            }
            return p;
        }
    }

    /**
     * 5、两个链表相交的点
     *   1.两个不带环的链表不相交 平行线
     *   2.两个不带环的链表相交 Y型
     *   3.一个带环 一个不带环链表 不相交 这种情况不存在
     *   4.两个带环链表不相交
     *   5.两个带环链表相交 交点在环内 （即环上）
     *   6.两个带环链表相交 交点在环外
     *   两链表逐步往后遍历，当链表A遍历完时，将链表B的头赋值给
     *   链表A,并继续遍历，同理，当链表B遍历完时，将链表A的头赋
     *   值给链表B,并继续遍历，直到两相等为止
     *
     *   该题就是将两个链表分别拼接上另外一个链表
     *   1->2->3->8->9->10
     *   4->8->9->10
     *
     *   1->2->3->8->9->10->4->8->9->10
     *   4->8->9->10->1->2->3->8->9->10
     *
     *   最后8->9->10就是相交的链表
     */
    public static ListNode getIntersector(ListNode headA, ListNode headB){
        ListNode p = headA;
        ListNode q = headB;
        while (p != q){
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }

    /**
     * 6、第2道题的补充
     * 删除链表的倒数第N个节点
     * p指针先走n步，p q再一起走，p走完了，q到的位置就是倒数n个位置，再q.next = q.next.next;
     */
    public static ListNode deleteNode(ListNode head,int n){
        ListNode p = head;
        ListNode q = head;
        for (int i=0;i<n;i++){
            p = p.next;
        }
        if (p == null){
            return q.next;
        }
        while (p.next != null){
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return head;
    }
}
