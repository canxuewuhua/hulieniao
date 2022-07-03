package com.hln.algorith.test;

/**
 * https://leetcode-cn.com/problems/reverse-string/
 * 反转字符串
 * 不要给另外的数组分配额外的空间
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 */
public class ReverseStringTest {

    public void reverseString(char[] s) {
        int l=0,r=s.length-1;
        while (l<r){
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
