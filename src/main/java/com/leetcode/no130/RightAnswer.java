package com.leetcode.no130;

/**
 * @Author MaggieCN
 * @Date 2021/11/4
 * @Description
 */
public class RightAnswer {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean border = (i == 0 || j ==0 || i == board.length-1 || j == board[0].length-1);
                if(border && board[i][j] == 'O'){
                    dfsArea(board, i, j);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'A'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void dfsArea(char[][] board, int i, int j){
        if(i < 0 || j <0 || i >= board.length || j >= board[0].length) return;
        if(board[i][j] !='O') return;
        board[i][j] = 'A';
        dfsArea(board, i+1, j);
        dfsArea(board, i-1, j);
        dfsArea(board, i, j+1);
        dfsArea(board, i, j-1);
    }
}
