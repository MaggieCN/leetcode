package com.leetcode.no01;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author MaggieCN
 * @Date 2021/9/5
 * @Description 数组两数之和等于target,输出数组的索引值
 * 1. 哈希容器
 * HashMap<Integer, Integer> key:nums[i] value:i
 * 遍历数组nums,每次把nums[i], i ，put进map中
 * 当nums[i] = target - hashmap.key，hashmap.value和i即为答案
 * 时间复杂度为O(1)
 */
public class RightAnswer {
    public static void main(String[] args) {
        int target = 9;
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + "," + result[1]);
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i< nums.length; i++) {
            if(map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]),i};
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
