package com.hln.algorith.字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class 无重复字符的最长子串 {

    public static void main(String[] args) {
//        String s = "abcabcbb";
//        System.out.println(lengthOfLongestSubstring(s));
        System.out.println('8' - '0');
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length()<=1) {
            return s.length();
        }
        int result=0;
        //通过哈希表来快速定位重复字符的最新位置
        Map<Character,Integer> map = new HashMap<>();

        //用快慢指针，快指针指向最新的下标，慢指针指向不重复的最小下标
        int fast =0;
        int slow =0;
        while(fast<s.length()) {
            if(map.containsKey(s.charAt(fast))) {
                slow = Math.max(slow, map.get(s.charAt(fast))+1);
            }
            map.put(s.charAt(fast), fast);
            result = Math.max(result, fast-slow+1);
            fast++;
        }
        return result;
    }
}
