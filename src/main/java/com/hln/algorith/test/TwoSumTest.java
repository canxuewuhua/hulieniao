package com.hln.algorith.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * Collections.sort(list);
 * 字符串 s.charAt(i)
 * Map<Character,Integer> map = HashMap<>();
 */
public class TwoSumTest {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < len; i++) {
            int result = target - nums[i];
            if (map.containsKey(result)){
                return new int[]{i, map.get(result)};
            }
            map.put(nums[i], i);
        }
        throw  new IllegalArgumentException("");
    }
}
