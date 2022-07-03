package com.hln.algorith.limingjie;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class _无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int fast = 0;
        int len = s.length();
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (fast<len){
            if (map.containsKey(s.charAt(fast))){
                slow = Math.max(slow, map.get(s.charAt(fast)) + 1);
            }
            result = Math.max(result, fast - slow + 1);
            map.put(s.charAt(fast), fast);
            fast++;
        }
        return result;
    }
}
