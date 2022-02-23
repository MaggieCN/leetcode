package dp;

/**
 * @author: gaomeiqi
 * @Date: 2022/2/16
 * @description:
 */
public class LC121 {
    /*
    * 输入：[7,1,5,3,6,4]
    * 输出：5
    * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     */
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        LC121 lc121 = new LC121();
        System.out.println(lc121.maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        /* 要有最小值，dp[i] = max(prices[i]-min, prices[i])
         * dp[0] 0
         * dp[1] 1
         * dp[2] 4
         * dp[3] 2
         * dp[4] 5
         * dp[5] 3
         */
        int[] dp = new int[prices.length];
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(prices[i]-min, dp[i-1]);
            min = Math.min(prices[i], min);
        }
        return dp[prices.length -1];
    }
    public int maxProfit1(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] =  0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[prices.length-1][0];
    }
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int res = 0;
        // 前一天卖出可以获得的最大利润
        int pre = 0;
        for (int i = 1; i < len; i++) {
            // 利润差
            int diff = prices[i] - prices[i - 1];
            // 状态转移方程：第i天卖出可以获得的最大利润 = 第i-1天卖出的最大利润 + 利润差
            pre = Math.max(pre + diff, 0);
            res = Math.max(res, pre);
        }
        return res;
    }
}
