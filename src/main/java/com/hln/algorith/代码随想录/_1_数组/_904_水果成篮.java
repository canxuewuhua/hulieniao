package com.hln.algorith.代码随想录._1_数组;

/**
 * https://leetcode-cn.com/problems/fruit-into-baskets/
 * 输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
 * 输出：5
 * 解释：可以采摘 [1,2,1,1,2] 这五棵树。
 */
public class _904_水果成篮 {

    public static void main(String[] args) {
        int i=0;
        for (; i < 3; ++i) {
            System.out.println(i);
        }
    }

    /**
     * 水果成篮问题 可以想象成 求只包含两种元素的最长连续子序列问题
     * @param fruits
     * @return
     */
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        if (n <= 2) return n;
        int total = 2;
        int left = 0;
        int right = 0;
        int count = 0; // 计算篮中种类数
        int[] fruitFrequence = new int[n]; // 计算篮中每种水果出现的次数。 因为提示中说明了水果的种类数是有限的 0 <= fruits[i] < fruits.length
        while (right<n){
            fruitFrequence[fruits[right]] ++; // 入篮
            if (fruitFrequence[fruits[right]] == 1) count++; //等于1说明第一次入篮，count需要加1
            while (count > 2) { // 篮中超过两种水果
                fruitFrequence[fruits[left]]--;  // 因为下边还要使用left下标，所以先不要移动  缩小窗口
                if (fruitFrequence[fruits[left]] == 0) count--; // 等于0说明篮中已经没有fruits[left]水果，count减1 缩小窗口至只有两个元素
                left++; // 移动left
            }
            total = Math.max(total, right - left + 1); // 取窗口最大值
            right++;
        }
        return total;
    }
}
