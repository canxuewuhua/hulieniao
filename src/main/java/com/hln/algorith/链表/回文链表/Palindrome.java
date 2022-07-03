package com.hln.algorith.链表.回文链表;


import com.hln.common.ListNode;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindromeStr("abcba"));;
    }

    public boolean isPalindrome(ListNode root){
        if (root == null || root.next == null) return true;
        if (root.next.next == null) return root.val == root.next.val;
        return false;
    }

    public ListNode getMiddle(ListNode root){
        if (root == null) return root;
        ListNode p = root;
        ListNode q = root;
        while (p!=null && p.next != null){
            p = p.next.next;
            q = q.next;
        }
        return q;
    }

    /**
     * 判断字符串是否为回文
     */
    public static boolean isPalindromeStr(String s){
        int len = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!=s.charAt(len-1)){
                return false;
            }else{
                len = len - 1;
            }
        }
        return true;
    }
}
