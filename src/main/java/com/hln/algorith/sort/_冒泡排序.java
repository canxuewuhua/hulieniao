package com.hln.algorith.sort;

public class _冒泡排序 {

    public static void main(String[] args) {
        int[] arr = {3,1,5,9,4,0};
        sortByBubble(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void sortByBubble(int[] arr){
        /**
         * 第一层循环是用来控制趟数，也就是 n 个数就要比较 n-1 趟
         * 第二层是控制第 i+1 趟（因为循环中 i 是从 0 开始的）的比较次数，那么 i+1 趟就是比较了 N-1-i 次
         */
        for (int i = 0; i < arr.length -1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
