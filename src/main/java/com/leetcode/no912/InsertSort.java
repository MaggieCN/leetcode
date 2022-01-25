package com.leetcode.no912;

/**
 * @Author MaggieCN
 * @Date 2021/11/12
 * @Description
 * {3, 2, 1, 4}
 * 3,2,1,4
 * {3,2}i = 1, j = 0
 * 2, 3, 1, 4 i =2 j =0
 */
public class InsertSort {
    // 插入排序：稳定排序，在接近有序的情况下，表现优异
    public static void main(String[] args) {
        int[] nums = {3,5,4,1};
        sortArray(nums);
    }
    public static int[] sortArray(int[] nums) {
        //int len = nums.length;
        // 循环不变量：将 nums[i] 插入到区间 [0, i) 使之成为有序数组
        for (int i = 1; i < nums.length; i++) {
            // 先暂存这个元素，然后之前元素逐个后移，留出空位
            int temp = nums[i];
            int j = i;
            // 注意边界 j > 0
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }
}
