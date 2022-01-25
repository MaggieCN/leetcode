package com.leetcode.no912;

/**
 * @Author MaggieCN
 * @Date 2021/11/12
 * @Description 选择排序
 * 每趟选择出该区间内最大（最小）的数，再跟最右（最左的）index 交换
 * 代码为最小值交换
 * 时间复杂度 n^2 不稳定
 */
public class SelectSort {
    public int[] sortArray(int[] nums) {
        for (int index = 0; index < nums.length; index++) {
            int min = nums[index];
            int minIndex = index;
            for (int j = index; j < nums.length; j++) {
                if(nums[j] < min){
                    minIndex = j;//最小值的下标
                    min = nums[j];//新的最小值更新
                }
            }
            swap(nums, index, minIndex);
        }
        return nums;
    }
    public void swap(int[] nums, int index, int j){
        int tmp = nums[index];
        nums[index] = nums[j];
        nums[j] = tmp;
    }

}
