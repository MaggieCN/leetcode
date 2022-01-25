package com.leetcode.no15;

import com.sun.jmx.snmp.SnmpUnknownMsgProcModelException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/7
 * @description:
 */
public class ThridSolution {
    public static void main(String[] args) {
        ThridSolution ts = new ThridSolution();
        int[] nums = {1,-1,-1,0};
        ts.threeSum(nums);
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        if (len < 3 || nums == null) return res;
        int sum, left, right;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            left = i + 1;
            right = len - 1;
            while (left < right) {
                sum = nums[left] + nums[right] + nums[i];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[left], nums[right], nums[i]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }else if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }
}
