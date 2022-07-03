package com.hln.algorith.代码随想录.回溯法三部曲;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BackTrackingTest {

    public static List<List<Integer>> result = new ArrayList<>();
    public static LinkedList<Integer> path = new LinkedList<>();

    /**
     * 比如1，2，3，4 每2个数进行组合 一共有多少结果
     */
    public static void backTracking(int n, int k, int startIndex){
        //终止条件
        if (path.size() ==k){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i=startIndex;i<=n;i++){
            path.add(i);
            backTracking(n,k,i+1);
            path.removeLast();
        }
    }




    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        backTracking(n,k,1);
        System.out.println(result);

    }
}
