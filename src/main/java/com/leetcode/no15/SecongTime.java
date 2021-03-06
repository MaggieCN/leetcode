package com.leetcode.no15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/28
 * @description:
 * 注意
 * 1.排除 nums[i] == nums[i -1] 而不是nums[i+1]
 * 2.while最后循环要判断sum > 0 sum < 0 而不是所有的都是left++ right--
 */
public class SecongTime {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            int sum ;
            while(left < right){
                sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }
                else if(sum<0 )left++;
                else if(sum>0 )right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        threeSum(nums);
    }
}
