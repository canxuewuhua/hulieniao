package com.hln.algorith.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    public static void main(String[] args) {
        NQueens queens = new NQueens();
        List<List<String>> res = queens.solveNQueens(4);
        System.out.println(res.size());
        for (List<String> list : res){
            System.out.println(list);
        }
    }

    /**
     * 定义全局二维数组记录结果
     */
    List<List<String>>  result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backtracking(n, 0, chessboard);
        return result;
    }


    public void backtracking(int n, int row, char[][] chessboard){
        if (row == n){
            // 终止条件 并搜集结果
            result.add(array2ToList(chessboard));
            return;
        }

        // 单层递归逻辑
        for (int col=0; col<n; col++){
            if (isValid(row, col, n, chessboard)){
                chessboard[row][col] = 'Q';
                backtracking(n, row + 1, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    private List array2ToList(char[][] chessboard){
        List<String> array2 = new ArrayList<>();
        for (char[] c : chessboard){
            array2.add(String.valueOf(c));
        }
        return array2;
    }

    private Boolean isValid(int row, int col, int n, char[][] chessboard){
        // 检查列
        for (int i=0; i<row; ++i) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
