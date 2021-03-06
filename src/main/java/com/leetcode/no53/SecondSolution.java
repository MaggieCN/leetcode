package com.leetcode.no53;

/**
 * @Author MaggieCN
 * @Date 2021/11/23
 * @Description
 */
public class SecondSolution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
