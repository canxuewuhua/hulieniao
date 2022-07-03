package com.hln.algorith.interview;

public class Test {

    public int maxSubArray(int[] arr){
        int dp = arr[0];
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp = Math.max(dp + arr[i], arr[i]);
            result = Math.max(result, dp);
        }
        return result;
    }

    public int max(){
        return 0;
    }

}
