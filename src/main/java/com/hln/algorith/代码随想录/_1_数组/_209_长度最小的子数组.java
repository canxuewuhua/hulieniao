package com.hln.algorith.代码随想录._1_数组;

public class _209_长度最小的子数组 {

    public static void main(String[] args) {
        int[] arr = {2,2,2,2,2,2};
        System.out.println(minSubArrayLen(7, arr));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        // 使用一层循环
        int len = nums.length;
        int s = 0;
        int res = Integer.MAX_VALUE;
        int k = 0;
        for(int i=0;i<len;i++){
            s+=nums[i];
            while(s>=target){
                int width = i - k + 1;
                res = res < width ? res : width;
                s-=nums[k++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
