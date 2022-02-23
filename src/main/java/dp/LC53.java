package dp;

/**
 * @author: gaomeiqi
 * @Date: 2022/2/15
 * @description:
 */
public class LC53 {
/*
    * nums        -2, 1, -3, 4, -1, 2, 1, -5, 4
    * -2    dp[0] -2
    *  1    dp[1] -2, -1 => -1
    * -3    dp[2] -4, -2, -3 => -1
    *  4    dp[3]  0, 2,  1, 4  => 4
    * -1    dp[4] -1, 1, 0, 3, -1 =>3
    *  2    dp[5]  1, 3, 2, 5, 1, 2 =>5
    *  1    dp[6]  2, 4, 3, 6, 2, 3, 1 =>6
    * -5    dp[7] -3, -1, -2, 1, -3, -2, -4, -5 =>1
    *  4    dp[8]  1, 3, 2, 5, 1, 2, 0, -1, 4 => 5
    *
 */
    public static void main(String[] args) {
        LC53 lc53 = new LC53();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        lc53.maxSubArray(nums);
    }
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
