package com.hln.algorith.interview;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

import java.util.Map;

/**
 *
 */
public class InterviewTest {

    public static void main(String[] args) {

        RangeMap<Integer, String> test = TreeRangeMap.create();
        test.put(Range.closed(1, 2), "xyb");
        test.put(Range.closed(10, 12), "Charlotte");
        test.put(Range.closed(5, 8), "love");
        for(Map.Entry<Range<Integer>, String> entry : test.asMapOfRanges().entrySet()) {
            System.out.println(entry.getKey()+"\t"+entry.getValue());
        }

        System.out.println(test.get(11));
        System.out.println(test.get(12));
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
            while (left < right && arr[right]>=base){
                right--;
            }
            arr[left] = arr[right];

            while (left < right && arr[left] <=base){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = base;
        return left;
    }
}
