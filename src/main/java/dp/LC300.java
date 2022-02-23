package dp;

import java.util.Arrays;

/**
 * @author: gaomeiqi
 * @Date: 2022/2/15
 * @description:
 */
public class LC300 {
 /*
    * nums = [0,1,0,3,2,3]
    * dp[0] 0 => 1
    * dp[1] nums[1] = 1 > 0 =>2
    * dp[2] => 1
    * dp[3] => 3
    * dp[4] => 3
    * dp[5] => 4
  */
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,2,3};
        LC300 lc300 = new LC300();
        System.out.println(lc300.lengthOfLIS(nums));
    }
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 1;
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
