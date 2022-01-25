package com.leetcode.no334;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/14
 * @description:
 */
public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3) return false;
        int left = 0;
        int mid = 1;
        int right = 2;
        while(left < nums.length-2 && mid <nums.length-1 && right<nums.length){
            if(nums[left]<nums[mid] && nums[mid]<nums[right]) return true;
            left++;
            mid++;
            right++;
        }
        return false;
    }
    public boolean increasingTriplet1(int[] nums) {
        if(nums.length < 3) return false;
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int i:nums) {
            if(i > mid) return true;
            else if(i<=min) min = i;
            else mid = i;
        }
        return false;
    }
}
