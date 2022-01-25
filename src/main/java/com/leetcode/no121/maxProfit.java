package com.leetcode.no121;

/**
 * @Author MaggieCN
 * @Date 2021/11/25
 * @Description
 * dp[i] = max(dp[i-1], prices[i] - min(prices [0-i-1])
 */
public class maxProfit {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length+1];
        dp[1] = 0;
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i+1] = Math.max(dp[i], prices[i]-min);
            max = Math.max(dp[i+1],max);
            min = Math.min(min,prices[i]);
        }
        return max;
    }
}
