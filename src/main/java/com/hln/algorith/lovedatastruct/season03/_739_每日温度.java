package com.hln.algorith.lovedatastruct.season03;

import java.util.Stack;

public class _739_每日温度 {

    public static void main(String[] args) {
        int[] arr = {73,74,75,71,69,72,76,73};
        int[] result = dailyTemperatures(arr);
        System.out.println(result);
    }

    public static int[] dailyTemperatures(int[] temperatures){
        if (temperatures == null || temperatures.length == 0) return null;
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int index = stack.peek();
                arr[index] = i - index;
                stack.pop();
            }
            stack.push(i);
        }
        return arr;
    }
}
