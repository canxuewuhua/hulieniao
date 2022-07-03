package com.hln.algorith.lovedatastruct.season03;

/**
 * 动态规划  Dynamic Programming
 * 动态规划  简称DP
 * 是求解最优化问题的一种常用策略
 *
 * 通常的使用套路 一步一步优化
 * 1、暴力递归 自顶向下 出现重叠子问题
 * 2、记忆化搜索
 * 3、递推 自低向上
 *
 * 47 礼物的最大价值
 * 64 最小路径和
 * 62 不同路径
 */
public class Solution03 {

    public static int maxValue(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];

        // 第0行
        for (int i = 1; i < rows; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        // 第0列
        for (int j = 1; j < cols; j++) {
            dp[j][0] = dp[j-1][0] + grid[j][0];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
