package com.hln.algorith.leetcode.正负数左移右移;

import java.util.concurrent.TimeUnit;

/**
 * [-1,4,-5,3,-2,-7,8]
 */
public class MoveTest {

    public static void main(String[] args) throws Throwable {
        TimeUnit.SECONDS.sleep(5);
    }

    public static void quickSort(int[] arr, int left, int right){
        if (left< right){
            int base = divide(arr, left,right);
            quickSort(arr, base+1, right);
            quickSort(arr, left, base-1);
        }
    }

    public static int divide(int[] arr, int left, int right){
        int base =  arr[left];
        while(left<right){
            while (left< right && arr[right]>=base){
                right--;
            }
            arr[left] = arr[right];
            while(left<right && arr[left]<=base){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = base;
        return left;
    }


}
