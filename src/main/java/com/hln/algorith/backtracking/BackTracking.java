package com.hln.algorith.backtracking;

import java.util.*;

/**
 * 回溯算法
 *
 * 回溯也即递归
 * 纯暴力搜索问题
 * 组合问题
 * 切割问题
 * 子集问题
 * 排列问题
 * 棋盘问题
 * 所有的回溯算法 都可以抽象为树形结构
 */
public class BackTracking {

    /**
     * 递归 一般都是void
     * void backTracking(参数){
     *     if(终止条件){
     *         收集结果
     *         return
     *     }
     * }
     *
     * 回溯三部曲
     * 递归函数的返回值以及参数 函数里一定有两个参数 集合n里取k的数 最后还有一个为startIndex
     * 确定终止条件
     * 单层递归逻辑
     *
     */
    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }


    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        LinkedList<Integer> path = new LinkedList<>();
        backTracking(n, k, 1, path, res);
        return res;
    }

    // 1、函数的返回值为void  参数
    // 2、if确定终止条件 收集结果 return;
    // 3、for循环递归逻辑
    public static void backTracking(int n, int k, int startIndex, LinkedList<Integer> path, List<List<Integer>> res){
        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }

        // for (int i = startIndex; i <= n; i++) 剪枝如下
        for (int i = startIndex;i<=n - (k - path.size()) + 1; i++){
            path.addLast(i);
            backTracking(n, k, i+ 1, path, res);
            path.removeLast();
        }
    }
}
