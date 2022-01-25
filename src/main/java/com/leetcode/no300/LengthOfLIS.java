package com.leetcode.no300;

/**
 * @Author MaggieCN
 * @Date 2021/10/11
 * @Description 最长递增子序列
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * nums[0] 10 min 10 count 1
 * nums[1] 9  min 9 nums[i] < min dp[0] = 9 count 1
 * nums[2] 2  min 2 count 0
 * nums[3] 5  min 2 nums[i] > min min 5 dp[1] = 5 count 1
 * nums[4] 3  nums[i]< min min 3 dp[1]= 3
 * nums[5] 7  nums[i]> min dp[2] = 7
 * nums[6] 101
 * nums[7]
 * [4,10,4,3,8,9] 会报错
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int min = nums[0];
        int[] dp=new int[nums.length];
        dp[0] = min;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < min){
                dp[count-1] = nums[i];
                min = nums[i];
            }else if(nums[i] > min){
                count++;
                dp[count-1] = nums[i];
                min = nums[i];
            }
        }
        return count;
    }
}
