package com.leetcode.offer12;

/**
 * @Author MaggieCN
 * @Date 2021/10/25
 * @Description DFS(这个是错误的，请看正确答案)
 */
public class Distinct {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','F'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dsfOfExist(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean dsfOfExist(char[][] board, String word, int i, int j, int len){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length) return false;
        if(word.charAt(len) != board[i][j]) return false;
        if(board[i][j] == '\0') return false;
        if(len == word.length() -1) return true;
        board[i][j] = '\0';
        boolean res = dsfOfExist(board, word, i-1, j, len+1) || dsfOfExist(board, word, i+1, j, len+1)||
                dsfOfExist(board, word, i, j-1, len+1) || dsfOfExist(board, word, i, j+1, len+1);
        return res;
    }
}
