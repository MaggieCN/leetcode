package com.leetcode.no122;

/**
 * @author: gaomeiqi
 * @Date: 2022/1/5
 * @description:
 */
public class RightAnsweer {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 0：持有现金
        // 1：持有股票
        // 状态转移：0 → 1 → 0 → 1 → 0 → 1 → 0
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        /*
        dp[i][0] 表示第i天持有股票所得现金。
        dp[i][1] 表示第i天不持有股票所得最多现金
         */
        for (int i = 1; i < len; i++) {
            // 这两行调换顺序也是可以的
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            System.out.println("第"+ i + "天持有现金的利润"+dp[i][0]);
            System.out.println("第"+ i + "天持有股票的利润"+dp[i][1]);
        }
        return dp[len - 1][0];
    }
}
