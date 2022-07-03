package com.hln.algorith.lovedatastruct.season03;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * abcabcbb 3 abc
 * pwwkew 3 wke kew 两种情况
 * 思路：遍历字符 以当前字符结尾 无重复的最长字符串 如 p pw w wk wke kew  有点像动态规划 在所有解中找到要的结果
 *  1、  pi *   li  i-1 i
 *    D         A   D
 *  2、  li *   pi  i-1 i
 *       A      D      D
 *  3、 li/pi       i-1 i
 *      D           A   D
 *
 *      一共两种情况 即 pi<li 为li------i
 *                   li<=pi 为li-----i
 */
public class Solution02 {
    public static void main(String[] args) {

    }

    public static int lengthOfLongestSubString(String str){
        if (str == null) return 0;
        Map<Character, Integer> prevIds = new HashMap<>();

        return 0;
    }

}
