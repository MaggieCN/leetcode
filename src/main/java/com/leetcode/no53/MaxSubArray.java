package com.leetcode.no53;

/**
 * @Author MaggieCN
 * @Date 2021/10/11
 * @Description
 *
输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
与nums[i] 是正是负没有关系，主要是dp[i-1] 不能为负数
 dp[i] 表示的是【0，i】到i 的累加和最大
 如果dp[i-1]<=0 nums[i] 无论是正是负，继续累加都比他本身要小，所以dp[i] = nums[i]
 反之dp[i-1]>0 继续累加就可以保持连续累加最大
 */
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if(dp[i-1]<=0) dp[i] = nums[i];
            else dp[i] = dp[i-1] + nums[i];
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
