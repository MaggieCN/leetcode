package com.leetcode.no300;

import java.util.Arrays;

/**
 * @Author MaggieCN
 * @Date 2021/10/11
 * @Description dp[i] dp[j] +1
 */
public class RightAnswer {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 0; i < dp.length ; i++) {
            for (int j = 0; j < i ; j++) {
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        int res = 0;
        for (int i : dp) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
