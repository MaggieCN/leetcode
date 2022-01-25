package com.leetcode.no322;

/**
 * @Author MaggieCN
 * @Date 2021/11/15
 * @Description
 * https://leetcode-cn.com/problems/coin-change/solution/javabei-wang-lu-dfs-dpyou-hua-quan-bu-zo-4599/
 * 示例 3：
 * 输入：coins = [1], amount = 0
 * 输出：0
 *
 * 示例 4：
 * 输入：coins = [1], amount = 1
 * 输出：1
 *
 * 示例 5：
 * 输入：coins = [1], amount = 2
 * 输出：2
 */
public class RightAnswer {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        //(1)初始化DP table，零钱为0则硬币0个
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        //(2)遍历每种【状态】即金额，【选择】即保存最少硬币数量
        for (int cur = 1; cur <= amount; cur++) {
            //(1.1)初始化DP table。初始为最大硬币数量即amount个，因为最小面额为1元，那么+1即为无法到达的硬币个数。当然取(amount+1,Integer.MAX_VALUE - 1)(ps:后面存在1+dp[balance]计算)范围都可
            dp[cur] = amount + 1;
            //(3)遍历每种面额的硬币
            for (int coin : coins) {
                //(3.1)剩余金额balance，为当前amount-某额度硬币
                int balance = cur - coin;
                //(3.2)剩余额度>=0，说明该种硬币的组合可行
                if (balance >= 0) {
                    //(3.3)说明amount额度足以减去某额度硬币。balance<cur，balance于前面已经计算保存好【状态】，+1为加上当前硬币
                    //例如1：coins[1,2,5]，cur=4
                    //①balance=4-1，此时dp[4]=min(初始值,1+dp[3]）,而dp[3]由1元+2元组合为2枚。保存最小值dp[4]=3
                    //②balance=4-2，此时dp[4]=min(初始值,1+dp[2])，而dp[2]由2元组合为1枚。保存最小值dp[4]=2
                    //③balance=4-5，不足以减去该面额
                    //例如2:coins[3]，cur=5。dp则为[0,max,max,1,max,max,max]，毕竟max<max+1
                    dp[cur] = Math.min(dp[cur], 1 + dp[balance]);
                }
            }
        }

        //(4)如amount等于初始值，说明在给定种类的硬币中无法组合成amount元。比如coin[2,3] amount=1,4...
        return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }
}
