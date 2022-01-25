package com.leetcode.offer42;

/**
 * @Author MaggieCN
 * @Date 2021/9/30
 * @Description
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/solution/cong-bao-li-po-jie-dao-dong-tai-gui-hua-yfvkp/
 */
public class RightAnswer {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
