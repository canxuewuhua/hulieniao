package com.hln.algorith.lovedatastruct.season03;

/**
 * leetcode 151
 * 字符串翻转
 * 思路：
 * 第一步：消除多余空格 尽管chars[]的总长度还是之前的长度
 * 第二步：对折翻转 chars[]总长度还是之前的长度
 * 第三步：就是使用String(char[],0,len) 到len就意味着进行了截取  就是空格这样的字符就去掉了
 *
 * 逆序 消除空格
 */
public class Solution01 {

    public static void main(String[] args) {
        String s = "are you ok  ";
        System.out.println(reverseWord(s));
    }

    public static void reverse(char[] chars, int li, int ri){
        ri--;
        while (li < ri){
            char temp = chars[li];
            chars[li] = chars[ri];
            chars[ri] = temp;
            li++;
            ri--;
        }
    }

    public static String reverseWord(String s) {
        if (s == null) return "";
        char[] chars = s.toCharArray();
        // 消除多余的空格
        int len = 0;// 说明：len和cur不一定是同一个长度
        int cur = 0;
        boolean space = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' '){
                // 非空格字符
                chars[cur++] = chars[i];
                space = false;
            }else {
                // 肯定是空格字符
                if (space == false){
                    // 来到else 肯定是遇到空格字符了 而且space==false隐藏说明上次肯定是非空格字符
                    chars[cur++] = ' ';
                    space = true;
                }
            }
        }
        len = space ? (cur-1) : cur;
        if (len<=0) return "";

        reverse(chars, 0 , len);

        // 对每一个单词进行逆序
        // 前一个空格字符的位置 有-1位置有一个假想的哨兵
        int prevSpaceIdx = -1;
        for (int i = 0; i < len; i++) {
            if (chars[i] != ' ') continue;
            reverse(chars, prevSpaceIdx + 1, i);// i就是空格字符的位置
            prevSpaceIdx = i;
        }
        //其实最后一个单词是没有翻转的
        reverse(chars, prevSpaceIdx+1, len);

        return new String(chars, 0 ,len);
    }
}
