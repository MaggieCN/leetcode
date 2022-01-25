package com.leetcode.no169;

import java.util.HashMap;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/7
 * @description:
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i]) > nums.length/2){
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MajorityElement mj = new MajorityElement();
        int[] nums = {3,2,3};
        mj.majorityElement(nums);
    }
}
