package com.leetcode.offer10;

/**
 * @Author MaggieCN
 * @Date 2021/9/30
 * @Description 青蛙跳台阶问题
 * 青蛙只能跳1级或者2级台阶，那要跳到n级总共有多少跳法
 * ------------------------------------------------
 * 可以总结为动态规划问题
 * dp[] 跳法 数量
 * dp[0] 0 1
 * dp[1] 1 1
 * dp[2] 11,2 2
 * dp[3] 12,111,21 3   (12 是从第一级台阶然后再走 111，21 是上到第二级台阶再走，所以总结为dp[n-1], dp[n-2])
 * dp[4] 121,211,1111,22,112 5
 */
public class FogNumWays {
    public static void main(String[] args) {
        System.out.println(numWays(4));
    }
    public static int numWays(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <=n ; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%1000000007;
        }
        return dp[n];
    }
}
