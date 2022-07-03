package com.hln.algorith;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * 给定一个int数组，其中两个数相加等于一个特定值，返回这两个数的索引
     *
     * int数组： [2, 7, 11, 15], 特定值 ： 9,
     * 因为： nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     * 网址：https://www.jianshu.com/p/e4a0c82cb143 三种解决方案 本文采用第三种
     */
    public static void main(String[] args) {

        String str1 = "abc";
        String str2 = "abc";
        String str3 = "abc";
        String str4 = "abc" + "abh";
        System.out.println(str1 == str2);
        System.out.println(str1 == str2.intern());
        System.out.println(str1 == str3.intern());
        System.out.println(str4 == str4.intern());
        System.out.println("-----------------------");
        String s4 = new String("hello");
        String s5 = new String("hello");
        System.out.println(s4 == s5);
        System.out.println(s4 == s4.intern());
        System.out.println(s4 == s5.intern());
//        int[] arr = {2, 7, 11, 15};
//        int[] result = twoSum(arr, 9);
//        for (int k=0;k<result.length;k++){
//            System.out.println(result[k]);
//        }
    }

    public static int[] twoSum(int[] arr, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<arr.length;i++){
            int complement = target - arr[i];
            if (map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(arr[i], i);
        }
        throw new IllegalArgumentException("No");
    }
}
