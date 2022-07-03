package com.hln.algorith.sort;

import com.hln.common.ListNode;

/**
 * 快速排序
 * 先右边 再左边 思想：选第一个作为基准点 从右边选择比基准点小的-交换  再从左边选择比基准点大的-交换 最终确定基准点的位置
 * quickSort param:arr left right
 * divide    param:arr left right 2022 03:49
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {15,3,8,54,5,10};
        quickSort(arr, 0, arr.length -1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void quickSort(int[] arr, int left, int right){
        if (left < right){
            int base = divide(arr, left, right);
            quickSort(arr, base + 1, right);
            quickSort(arr, left, base - 1);
        }
    }

    public static int divide(int[] arr, int left, int right){
        int base = arr[left];
        while (left < right){
            while (left<right && arr[right] >=base){
                right--;
            }
            arr[left] = arr[right];// 比如说基准点为6-首位  从右边找到了一个3，此时将首位赋值为3

            while (left<right && arr[left] <=base){
                left++;
            }
            arr[right] = arr[left];// 比如说从左边找到一个7，此时将7赋值给6的那个位置
        }
        arr[left] = base;// left是一直++ 所以最终left下标是base的位置
        return left;// left作为分割点 左一部分 右一部分 重新进入下一轮
    }
}
