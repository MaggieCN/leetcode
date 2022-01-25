package com.leetcode.no334;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/14
 * @description:
 * https://leetcode-cn.com/problems/increasing-triplet-subsequence/solution/java-tan-xin-by-feilue-usn7/
 *
 */
public class RightAnswer {
    public static void main(String[] args) {
        RightAnswer rightAnswer = new RightAnswer();
        int[] nums = {20,100,10,12,5,13};
        rightAnswer.increasingTriplet(nums);
    }
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;

        int min = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for(int i : nums){
            if(i > mid) return true;
            if(i <= min) min = i;
            else mid = i;
        }

        return false;
    }
}
