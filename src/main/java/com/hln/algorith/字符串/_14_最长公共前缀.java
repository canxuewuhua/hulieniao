package com.hln.algorith.字符串;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串""。
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 */
public class _14_最长公共前缀 {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < len; i++) {
            while (strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
