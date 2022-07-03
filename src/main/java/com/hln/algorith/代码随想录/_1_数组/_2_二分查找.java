package com.hln.algorith.代码随想录._1_数组;

public class _2_二分查找 {
    public static void main(String[] args) {
        // 有序数组
        int[] arr = {2,10,12,15,25,30};
        System.out.println(binSearch(arr, 12));

    }
    public static int binSearch(int[] arr, int key){
        int left = 0;
        int right = arr.length - 1;
        // 边界问题要弄清 如果是<= 因为arr[mid] > key arr[mid]一定不是target 那么接下来就要找左区间结束下标位置就是middle-1
        while (left<=right){
            int mid = left + (right - left)/2;
            if (arr[mid] >key){
                right = mid - 1;
            }else if (arr[mid] == key){
                return mid;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }


}
