package com.leetcode.no01;

import java.util.HashMap;

/**
 * @Author MaggieCN
 * @Date 2021/11/24
 * @Description
 */
public class SecondSolution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;
            }
            map.put(nums[i],i);
        }
        return res;
    }
}
