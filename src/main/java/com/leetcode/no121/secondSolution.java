package com.leetcode.no121;

/**
 * @author: gaomeiqi
 * @Date: 2022/1/3
 * @description:
 */
public class secondSolution {
    public static void main(String[] args) {
        secondSolution secondSolution = new secondSolution();
        System.out.println(secondSolution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
    public int maxProfit(int[] prices) {
        int[] dp =  new int[prices.length + 1];
        dp[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length ; i++) {
            min = Math.min(min, prices[i]);
            dp[i] = Math.max(dp[i-1], prices[i] - min);
        }
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(dp[i], dp[i-1]);
        }
        return max;
    }
}
