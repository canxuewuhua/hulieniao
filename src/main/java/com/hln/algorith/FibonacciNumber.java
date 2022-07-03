package com.hln.algorith;

public class FibonacciNumber {

    public static void main(String[] args) {
        System.out.println(fib2(0));
        System.out.println(fib2(1));
        System.out.println(fib2(2));
        System.out.println(fib2(3));
        System.out.println(fib2(4));
        System.out.println(fib2(8));
        System.out.println(fib3(8));
    }

    /**
     * 斐波那契数列
     * 0 1 2 3 4 5 6 7  8
     * 0 1 1 2 3 5 8 13 21
     */

    /**
     * 第一种使用递归的方式 递归调用的空间复杂度为O(n) 时间复杂度为O(2^n)
     */
    public static int fib1(int n){
        if (n<=1) return n;
        return fib1(n - 2) + fib1(n - 1);
    }

    /**
     * 递归的优化方式 可使用一个数组 去除重复调用 大大减少了重复次数
     * 优化后的时间复杂度为O(n) 空间复杂度为O(n)
     */
    public static int fib3(int n){
        if (n <= 2) return 1;
        int[] array = new int[n + 1];
        array[2] = array[1] = 1;
        return fib3(array, n);

    }
    private static int fib3(int[] array, int n){
        if (array[n] == 0){
            array[n] = fib3(array, n - 1) + fib3(array, n - 2);
        }
        return array[n];
    }

    /**
     * 滚动数组
     * 当发现每次都使用两个元素的时候就可以使用滚动数组
     * 模运算 效率低 可以使用 i & 1 == i % 2 但必须是模2的时候
     */
    public static int fib4(int n){
        if (n <= 2) return 1;
        int[] array = new int[2];
        array[0] = array[1] = 1;
        for (int i = 3; i <=n; i++) {
            array[i % 2] = array[(i - 1) % 2] + array[(i - 2) % 2];
        }
        return array[n % 2];
    }

    /**
     * 第二种使用非递归的方式
     * preOne preTwo result 可以按照斐波那契数列的最开始的值
     * i循环就从0开始，去到n 就能加出来n对应的值  当然循环只能到n 所以i < n - 1 或者 i<=n
     */
    public static int fib2(int n){
        if (n<=1) return n;
        int preOne = 1;
        int preTwo = 0;
        int result = 1;
        for (int i = 0; i < n - 1; i++) {
            result = preOne + preTwo;
            preTwo = preOne;
            preOne = result;
        }
        return result;
    }
}
