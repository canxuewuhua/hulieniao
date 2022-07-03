package com.hln.algorith.test;

import java.util.*;

/**
 * arr1 = {1,2,5}
 * arr2 = {2,3,9,12}
 * merge = {1,2,2,3,5,9,12}
 */
public class Merge {

    public static void main(String[] args) {
        int[] arr1 = {1,2,5};
        int[] arr2 = {2,3,9,12};
        int[] result = mergeArr(arr1, arr2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        List<Integer> list = Arrays.asList(3,1,5,2,9);
        Collections.sort(list);
        System.out.println(list);
    }
    public static int[] mergeArr(int[] arr1, int[] arr2){
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr1.length; i++) {
            queue.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            queue.add(arr2[i]);
        }
        int[] arr = new int[arr1.length + arr2.length];
        int k = 0;
        while (queue.size()>0){
            int m = queue.poll();
            arr[k] = m;
            k++;
        }
        return arr;
    }
}
