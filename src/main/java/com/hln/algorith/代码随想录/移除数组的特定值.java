package com.hln.algorith.代码随想录;

/**
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 */
public class 移除数组的特定值 {

    public static int remove(int[] arr, int m){
        int fast = 0,slow = 0;
        int len = arr.length;
        while (fast<len){
            if (arr[fast] != m){
                arr[slow++] = arr[fast];
            }
            fast++;
        }
        return slow;
    }

    /**
     * 快慢指针 而且是没有使用额外空间  双指针解法
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        int len = remove(arr, 2);
        System.out.println(len);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int removeElement(int[] arr, int target){
        int len = arr.length;
        int slow = 0;
        for (int fast = 0; fast < len; fast++) {
            if (arr[fast]!=target){
                arr[slow++] = arr[fast];
            }
        }
        return slow;
    }
}
