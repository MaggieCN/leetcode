package com.leetcode.offer63;

import java.util.HashMap;

/**
 * @Author MaggieCN
 * @Date 2021/9/29
 * @Description
 * 原本思路是先找到最小值，再其右侧找到最大值。但【2，4，1】会错误
 * 正确思路：
 * 前i日最大利润=max(前(i−1)日最大利润,第i日价格−前i日最低价格)
 * dp[i]=max(dp[i−1],prices[i]−min(prices[0:i]))
 * 初始状态： dp[0] = 0 ，即首日利润为 0 ；
 * 返回值： dp[n - 1] ，其中 n 为 dp 列表长度。
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
    }
    public static int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int min = prices[0];
        for (int i = 1; i < dp.length; i++) {
            min = Math.min(min,prices[i]);
            dp[i] = Math.max(dp[i-1],prices[i]-min);
        }
        return dp[prices.length-1];
    }
}
