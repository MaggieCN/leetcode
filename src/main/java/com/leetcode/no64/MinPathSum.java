package com.leetcode.no64;

/**
 * @Author MaggieCN
 * @Date 2021/10/11
 * @Description
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp =  new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if(i == 0){
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }else if (j == 0){
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j]+ grid[i][j], dp[i][j-1] + grid[i][j]);
                }
            }
        }
        return dp[row-1][column-1];
    }
}
