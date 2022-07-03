package com.hln.algorith.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class Hot01 {
    public int[] twoSum(int[] nums, int target) {
        // 采用查找表方式 hash
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < len; i++) {
            int result = target - nums[i];
            if (map.containsKey(result)){
                return new int[]{i, map.get(result)};
            }
            map.put(nums[i], i);
        }
        throw  new IllegalArgumentException("NO ...");
    }

    public void fun(){
        new Thread(()->{

        }, "t1").getState();
    }
}
