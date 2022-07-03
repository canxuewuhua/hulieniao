package com.hln.algorith.fibonacci;

public class FibonacciBasic {

    public static void main(String[] args) {
        System.out.println(fibonacci(4));
    }

    public static int fibonacci(int n){
        if (n<=0) return 0;
        if (n==1 || n==2) return 1;
        int preOne = 1;
        int preTwo = 0;
        int result = 1;
        for (int i=2;i<=n;i++){
            result = preOne + preTwo;
            preTwo = preOne;
            preOne = result;
        }
        return result;
    }
}
