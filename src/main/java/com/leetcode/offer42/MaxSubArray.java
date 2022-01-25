package com.leetcode.offer42;

/**
 * @Author MaggieCN
 * @Date 2021/9/30
 * @Description
 * -----------------------------------
 * sum(0,i)最大值的问题
 * dp[i] 存放的是sum（[0-i-1]，i）的最大值
 * dp[i-1]<= 0 dp[i]=nums[i]
 * dp[i-1]> 0 dp[i]=dp[i-1]+nums[i]
 * 最后再求max(dp[])
 * -------------------------------------
 * [-3,4,-1,2,-5,1]
 * dp[0] sum(0,0) -3  sum(0,0)
 * dp[1] sum(0,1) sum(1,1) 1,4  4  sum(1,1)
 * dp[2] sum(0,2) sum(1,2) sum(2,2) 0,3,-1  3  sum(1,2)
 * dp[3] sum(0,3) sum(1,3) sum(2,3) sum(3,3) 2,5,1,2 5  sum(1,3)
 * dp[4] sum(0,4) sum(1,4) sum(2,4) sum(3,4) sum(4,4) -3,0,-4,-3,-5 0 sum(1,4)
 * dp[5] sum(0,5) sum(1,5) sum(2,5) sum(3,5) sum(4,5) sum(5,5) -2,1,-3,-2,1,-4  1 sum(1,5)/sum(4,5)
 *
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if(dp[i-1]<=0) dp[i] = nums[i];
            else dp[i] = dp[i-1] + nums[i];
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
