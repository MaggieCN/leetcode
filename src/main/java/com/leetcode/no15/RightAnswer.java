package com.leetcode.no15;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author MaggieCN
 * @Date 2021/9/5
 * @Description 数组两数之和等于target,输出数组的索引值
 * 1. 排序+双指针
 * 标签：数组遍历
 * 首先对数组进行排序，排序后固定一个数 nums[i]，
 * 再使用左右指针指向 nums[i]后面的两端，数字分别为 nums[L] 和 nums[R]，
 * 计算三个数的和 sum 判断是否满足为 0，满足则添加进结果集
 * 如果 nums[i]大于 0，则三数之和必然无法等于 0，结束循环
 * 如果 nums[i] == nums[i-1]，则说明该数字重复，会导致结果重复，所以应该跳过
 * 当 sum == 0 时，nums[L] == nums[L+1] 则会导致结果重复，应该跳过，L++
 * 当 sum == 0 时，nums[R] == nums[R-1] 则会导致结果重复，应该跳过，R--
 * 时间复杂度：O(n^2)，n 为数组长度
 */
public class RightAnswer {
    public static void main(String[] args) {
        int[] nums = new int[]{1,-1,-1,0};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if(nums == null || len < 3) return result;
        Arrays.sort(nums);
        int sum, left, right;
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break;
            if(i >0 && nums[i] == nums[i-1]) continue;
            left = i + 1;
            right = len - 1;
            while(left<right){
                sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }
                else if(sum < 0) left ++;
                else if(sum > 0) right --;
            }
        }
        return result;
    }
}
