package com.hln.algorith.test;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test {

    /**
     * 合并两个有序数组
     */
    public static void main(String[] args) {
        String s1 = "flo";
        String s2 = "flow";
        System.out.println(s2.indexOf(s1));
    }

    /**
     * 快排
     */
    public void quickSort(int[] arr, int left, int right){
        if (left<right){
            int base = divide(arr, left, right);
            quickSort(arr, base+ 1, right);
            quickSort(arr, left, base-1);
        }
    }
    public static int divide(int[] arr, int left, int right){
        int base = arr[left];
        while (left<right){
            while (left<right && arr[right]>=base){
                right--;
            }
            arr[left] = arr[right];
            while (left<right && arr[left]<=base){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = base;
        return left;
    }

    /**
     * 二分查找
     * @param nums
     * @param m
     * @return
     */
    public static int binSearch(int[] nums, int m){
        int low = 0;
        int high = nums.length - 1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if (nums[mid] > m){
                high = mid - 1;
            }else if(nums[mid] == m){
                return mid;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }


}
