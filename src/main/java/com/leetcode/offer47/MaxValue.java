package com.leetcode.offer47;

/**
 * @Author MaggieCN
 * @Date 2021/10/11
 * @Description m行n列的棋盘
 * 例如：
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * dp[0][0] = 1
 * dp[0][1] = grid[0][0] + grid[0][1] = dp[0][0] + grid[0][1] =4
 * dp[0][2] = grid[0][0] + grid[0][1] + grid[0][2] = dp[0][1] + grid[0][2] = 5
 * dp[1][0] = grid[0][0] + grid[1][0] = dp[0][0] + grid[1][0] = 2
 * dp[1][1] = grid[0][0] + grid[0][1] + grid[1][1] = dp[0][1] + grid[1][1] = 9
 *          = grid[0][0] + grid[1][0] + grid[1][1] = dp[1][0] + grid[1][1] = 7
 * dp[1][2] = dp[0][2] + grid[1][2] = 6
 *          = dp[1][1] + grid[1][2] = 10
 * dp[2][0] = grid[0][0] + grid[1][0] + grid[2][0] = dp[1][0] + grid[2][0] = 6
 * dp[2][1] = dp[2][0] + grid[2][1] = 8
 *          = dp[1][1] + grid[2][1] = 11
 * dp[2][2] = dp[2][1] + grid[2][2] = 12
 *          = dp[1][2] + grid[2][2] = 11
 */
public class MaxValue {
    public int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for(int j = 0;j< grid[i].length; j++){
                if(i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if(i == 0){
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }else if (j == 0){
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j]+ grid[i][j], dp[i][j-1] + grid[i][j]);
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
