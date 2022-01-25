package com.leetcode.no36;

import java.util.*;

/**
 * @Author MaggieCN
 * @Date 2021/11/27
 * @Description
 */
public class IsValidSudoKu {
    public boolean isValidSudoku(char[][] board) {
        /**
         *         HashMap<Integer, HashMap<Integer,Integer>> rowMap = new HashMap<>();
         *         HashMap<Integer, HashMap<Integer,Integer>> columnMap = new HashMap<>();
         *         HashMap<Integer, HashMap<Integer,Integer>> blockMap = new HashMap<>();
         *         int tmpNum = 0;
         *         for (int i = 0; i < board.length; i++) {
         *             for (int j = 0; j < board[0].length; j++) {
         *                 if(board[i][j] == '.') continue;
         *                 Integer tmp = Integer.valueOf(board[i][j]);
         *                 HashMap<Integer, Integer> rowTmp = new HashMap<>();
         *                 HashMap<Integer, Integer> colTmp = new HashMap<>();
         *                 HashMap<Integer, Integer> blockTmp = new HashMap<>();
         *                 rowTmp.put(j,tmp);
         *                 rowMap.put(i,rowTmp);
         *                 colTmp.put(i, tmp);
         *                 columnMap.put(j,colTmp);
         *                 blockTmp.put(tmpNum++, tmp);
         *                 blockMap.put(i%3 + j%3, blockTmp);
         *                 if(tmpNum == 9) tmpNum = 0;
         *             }
         *         }
         *         for (int i = 0; i < 9 ; i++) {
         *             if(rowMap.get(i).get(i) == 1)
         *         }
         *         return true;
          */
        return true;
    }
}
