package com.hln.algorith;

public class StockMaxProfit {

    /**
     * 题目：一个数组表明股票天天的价格，能够选择从某一天买入，而后以后的一天卖出，求可以得到的最大收益。
     * [3,4,5,6,5,8]
     * 题目背景
     * 如果我们真的在买卖股票，我们肯定会想：如果我是在历史最低点买的股票就好了！太好了，
     * 在题目中，我们只要用一个变量记录一个历史最低价格 minprice，我们就可以假设自己的股票是在那天买的。
     * 那么我们在第 i 天卖出股票能得到的利润就是 prices[i] - minprice。
     *
     * 因此，我们只需要遍历价格数组一遍，记录历史最低点，然后在每一天考虑这么一个问题：
     * 如果我是在历史最低点买进的，那么我今天卖出能赚多少钱？当考虑完所有天数之时，我们就得到了最好的答案。
     *
     * 注意：肯定是某一天最低点进行买入 某一天低点买入不会当天卖出  要等其他天高点进行卖出
     *      所以用if  else if 进行判断 也不会条件冲突
     */
    public static void main(String[] args) {
//        int arr[] = {9,11,8,5,7,12,16,14};
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
//        int arr[] = {7,1,5,3,6,4};
        System.out.println(getMaxProfit(arr));
        System.out.println(getMaxValueByDB(arr));
    }

    public static int max(int[] arr){
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        return max;
    }

    /**
     * **思路：**记录当前最小值和最大差值
     */
    public static int getMaxProfit(int[] arr){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]<minPrice){
                minPrice = arr[i];
            }else if (arr[i]-minPrice>maxProfit){
                maxProfit = arr[i] - minPrice;
            }
        }
        return maxProfit;
    }

    /**
     * 可使用动态规划进行计算  也就是求 最大连续子序列和 的问题
     * 难点在于 状态定义 dp[i]
     * 假设dp[i]是以prices[i]结尾的最大连续子序列的和
     * 状态转移方程
     * 如果dp(i-1)<=0，那么dp(i) = prices[i]
     * 如果dp(i-1)>0，那么dp(i)= dp(i-1) + prices[i]
     *
     * 初始状态
     * dp(0)的值是prices[0]
     * 最终的连续子序列和是所有dp(i)的最大值
     *
     * 也可以使用滚动数组的方式 覆盖dp 空间复杂度变为O(1) 时间复杂度O(n)
     * 122 买卖股票的最佳时机II
     * 123 买卖股票的最佳时机 III
     * 188 买卖股票的最佳时机 IV
     * 714 买卖股票的最佳时机包含手续费
     */
    public static int getMaxValueByDB(int[] prices){
        if (prices == null || prices.length == 0) return 0;
        // 将数组两两相减
        int[] arr = new int[prices.length-1];
        for (int i = 1; i < prices.length; i++) {
            arr[i-1] = prices[i] - prices[i - 1];
        }

        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i-1] <=0){
                dp[i] = arr[i];
            }else {
                dp[i] = dp[i-1] + arr[i];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
