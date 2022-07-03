package com.hln.algorith;

/**
 * 二分查找 前提是数组有序 最终目的是找到key的数组下标即可
 * 递归和非递归两种方式
 * 非递归 使用while 移动low和high指针
 * 递归   调用自身 low参数和high参数使用mid加一减一
 */
public class BinSearchByArray {

    /**
     * 非递归算法 参数 arr len key
     */
    public static int nonRecursionSearch(int[] arr, int len, int key){
        int low = 0,high = len - 1;
        while (low<=high){
            int mid = (low + high)/2;
            if (arr[mid] == key){
                return mid;
            }else if (arr[mid] > key){
                high = mid - 1;
            }else if (arr[mid] < key){
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 递归算法 参数 arr low high key
     */
    public static int recursionSearch(int[] arr, int low, int high, int key){
        if (low<=high){
            int mid = (low+high)/2;
            if (arr[mid] == key){
                return mid;
            }else if (arr[mid] > key){
                return recursionSearch(arr, low, mid -1, key);
            }else if (arr[mid] < key){
                return recursionSearch(arr, mid+1, high, key);
            }
            return mid;
        }else {
            return -1;
        }
    }
}
