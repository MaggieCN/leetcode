package com.leetcode.no198;

/**
 * @author: gaomeiqi
 * @Date: 2022/1/5
 * @description:
 */
public class rob {
    public static void main(String[] args) {
        rob rob = new rob();
        System.out.println(rob.rob(new int[]{7, 2, 9, 3, 1, 8}));
    }
    public int rob(int[] nums) {
        if (nums.length < 2) return nums[0];
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length ; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[nums.length - 1];
    }
}
