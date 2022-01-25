package com.leetcode.no36;

/**
 * @Author MaggieCN
 * @Date 2021/11/27
 * @Description
 */
public class RightAnswer {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][]col = new int[9][9];
        int[][][] block = new int[3][3][9];
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[0].length ; j++) {
                char c = board[i][j];
                if(c !='.'){
                    int index = c - '0' -1;
                    row[i][index] ++;
                    col[index][j] ++;
                    block[i/3][j/3][index] ++;
                    if(row[i][index] >1 || col[index][j] >1 || block[i/3][j/3][index] >1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
