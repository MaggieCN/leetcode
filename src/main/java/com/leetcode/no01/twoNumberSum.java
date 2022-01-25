package com.leetcode.no01;

/**
 * @Author MaggieCN
 * @Date 2021/9/4
 * @Description
 */
public class twoNumberSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        int target = 4;
        int[] result = twoSum(nums, target);
        System.out.println(result[0]+","+result[1]);

    }
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i< nums.length; i++) {
            for(int j = i+1; j< nums.length; j++){
                if(target == nums[i] + nums[j]){
                    result[0] = nums[i];
                    result[1] = nums[j];
                    break;
                }
            }
        }
        return result;
    }
}
