package com.leetcode.no122;

/**
 * @author: gaomeiqi
 * @Date: 2022/1/4
 * @description:
 * 二维动态规划
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/
 */
public class MaxProfit {
    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        maxProfit.maxProfit(new int[]{7,1,5,3,6,4});
    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i <prices.length ; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
        }
        return dp[prices.length-1][0];
    }
}
