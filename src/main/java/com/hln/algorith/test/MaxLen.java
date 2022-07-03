package com.hln.algorith.test;

import java.util.HashMap;
import java.util.Map;

/**
 *   给定一个长度为n的数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
 *
 *   子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
 */
public class MaxLen {

    public static void main(String[] args) {
        int[] arr = {2,3,4,5,3};
        System.out.println(mexLen(arr));
    }

    /**
     * 输入： [2,3,4,5]
     * 输出： 4
     * 说明： [2,3,4,5]是最长子数组
     * @param arr
     * @return
     */
    public static int mexLen(int[] arr){
        int fast = 0;
        int slow = 0;
        int len = arr.length;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(fast<len){
            if (map.containsKey(arr[fast])){
                slow = Math.max(slow, map.get(arr[fast])+1);
            }
            map.put(arr[fast],fast);
            result = Math.max(result, fast - slow + 1);
            fast++;
        }
        return result;
    }
}
