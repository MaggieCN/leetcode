package com.leetcode.offer63;

/**
 * @Author MaggieCN
 * @Date 2021/9/29
 * @Description
 */
public class RightAnswer {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int res = 0, min = prices[0];
        for(int i = 1; i < prices.length; i ++){
            min = Math.min(min, prices[i-1]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}
