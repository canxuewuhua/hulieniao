package com.hln.algorith.interview;

public class Test3 {

    private static void execute2(int[] array, int m) {
        for(int i = 0; i < array.length; i++) {
            int tmp = m - array[i];
            if (tmp > array[i]) {
                if (binarySearch(array, tmp) != -1) {
                    System.out.println(array[i] + " " + tmp);
                }
            }
        }
    }
    private static int binarySearch(int[] array, int key) {
        if (array.length == 0) {
            return -1;
        }
        int first = 0;
        int last = array.length -1;
        int mid;
        while(first <= last) {
            mid = (first + last) / 2;
            if (array[mid] == key) {
                return mid;
            } else if (array[mid] < key) {
                first = mid + 1;
            } else {
                last = mid -1;
            }
        }
        return -1;
    }
}
