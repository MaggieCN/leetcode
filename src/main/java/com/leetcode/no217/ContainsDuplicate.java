package com.leetcode.no217;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author MaggieCN
 * @Date 2021/11/23
 * @Description
 * 1. 使用数组排序的方式
 * 2. 使用Set存放非重复数组
 * 3. intStream
 */
public class ContainsDuplicate {
    /**
     * 1. 使用数组排序的方式
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i - 1] == nums[i])
                return true;
        }
        return false;
    }
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        //使用set.add() set.contain 都可以判断是否set中包含同样的key
        boolean res = true;
        for (int num : nums) {
            res = res && set.add(num);
        }
        return res;
    }
}
