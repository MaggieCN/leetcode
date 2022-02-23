package dp;

import java.util.Arrays;

/**
 * @author: gaomeiqi
 * @Date: 2022/2/16
 * @description:
 */
/*
给定一个数组 prices ，其中 prices[i] 表示股票第 i 天的价格。
在每一天，你可能会决定购买和/或出售股票。你在任何时候最多只能持有一股股票。你也可以购买它，然后在同一天出售。
返回你能获得的最大利润 。
 */
public class LC122 {
    /*
     * 输入: prices = [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     */
    public static void main(String[] args) {
        LC122 lc122 = new LC122();
        int[] prices = {7,1,5,3,6,4};
        lc122.maxProfit2(prices);
    }
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) profit += tmp;
        }
        return profit;
    }

    public int maxProfit2(int[] prices){
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0 ;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] + prices[i]);
        }
        return dp[prices.length-1][0];
    }
    public int maxProfit1(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) profit += tmp;
        }
        return profit;
    }
}
