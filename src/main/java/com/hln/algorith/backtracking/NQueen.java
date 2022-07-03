package com.hln.algorith.backtracking;

import java.util.LinkedList;
import java.util.List;

public class NQueen {

    //记录皇后摆放位置索引为行号,数值为列号
    private int[] cols;
    //记录最终数据
    List<List<String>> paths = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        cols = new int[n];
        //从第0行开始摆放
        place(0);
        return paths;
    }

    /**
     * 在第row行摆放皇后
     *
     * @param row
     */
    private void place(int row) {
        for (int col = 0; col < cols.length; col++) {
            if (isValid(row, col)) {
                cols[row] = col;
                //说明最后一行成功摆放皇后,记录路径信息继续尝试其他可能
                if (row == cols.length - 1) {
                    LinkedList<String> path = new LinkedList<>();
                    for (int value : cols) {
                        path.add(getStringPath(value));
                    }
                    paths.add(path);
                    //不是最后一行,下一行继续尝试摆放
                } else place(row + 1);
            }
        }
    }


    /**
     * 确定第row行第col列是否可以摆放皇后
     *
     * @param row
     * @param col
     * @return
     */
    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (col == cols[i] || Math.abs(col - cols[i]) == row - i)
                return false;
        }
        return true;
    }

    //生成题目所需字符串
    private String getStringPath(int index) {
        StringBuilder sb = new StringBuilder(cols.length);
        for (int i = 0; i < cols.length - 1; i++) {
            sb.append(".");
        }
        sb.insert(index, "Q");
        return sb.toString();
    }

}
