package com.leetcode.no747;

/**
 * @author: gaomeiqi
 * @Date: 2022/1/13
 * @description:
 */
public class DominantIndex {
    public static void main(String[] args) {
        DominantIndex dominantIndex = new DominantIndex();
        System.out.println(dominantIndex.dominantIndex(new int[]{0,0,3,2}));
    }
    public int dominantIndex(int[] nums) {
        int leftMaxIndex = -1;
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[maxIndex]){
                leftMaxIndex = maxIndex;
                maxIndex = i;
            }else if(leftMaxIndex == -1 || nums[i] < nums[maxIndex]){
                leftMaxIndex = i;
            }
        }
        return nums[leftMaxIndex] *2 <= nums[maxIndex] ? maxIndex : -1;
    }
}
