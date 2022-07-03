package com.hln.algorith.test;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *  *合并两个有序数组
 */
public class MergeArrayTest {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 归并排序的思想 使用3个指针
        int i1 = m - 1;
        int i2 = n - 1;
        int cur = nums1.length - 1;
        while(i2 >= 0){
            if(i1>=0 && nums1[i1] > nums2[i2]){
                nums1[cur--] = nums1[i1--];
            }else {
                // i1<0  || nums2[i2] >= nums1[i1]
                nums1[cur--] = nums2[i2--];
            }
        }
    }
}
