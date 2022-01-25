package com.leetcode.offer12;

/**
 * @Author MaggieCN
 * @Date 2021/10/25
 * @Description DFS
 */
public class RightAnswer {
    public boolean exist(char[][] board, String word) {
        /* 每次循环都是从word.charAt(0)开始的
         * 从棋盘的任何位置开始，遍历，如果存在return true
         */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dsfOfExist(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dsfOfExist(char[][] board, String word, int i, int j, int len){
        /* 三个剪枝：1. 超过边界 2. 当前word字母与棋盘字母不同 3.
         * len长度等于word的时候，表示已经查询完毕。
         * 上下左右四个方向查找有无接下来的字母
         */
        if(i<0 || j<0 || i>=board.length || j>=board[0].length) return false;
        if(word.charAt(len) != board[i][j]) return false;
        if(board[i][j] == '\0') return false;
        if(len == word.length() -1) return true;
        board[i][j] = '\0';
        boolean res = dsfOfExist(board, word, i-1, j, len+1) || dsfOfExist(board, word, i+1, j, len+1)||
                dsfOfExist(board, word, i, j-1, len+1) || dsfOfExist(board, word, i, j+1, len+1);
        /*
        回退，例如：[["C","A","A"],["A","A","A"],["B","C","D"]]   "AAB"
        把board被改为'\0'的改成原本的字母
         */
        board[i][j] = word.charAt(len);
        return res;
    }
}
