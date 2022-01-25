package com.leetcode.no912.fastSort;

import java.util.Random;

/**
 * @author: gaomeiqi
 * @Date: 2022/1/2
 * @description:
 */
public class thridSolution {
    public static void main(String[] args) {
        int[] nums = {5,1,1,2,0,0};
        thridSolution thridSolution = new thridSolution();
        thridSolution.sortArray(nums);
    }
    public int[] sortArray(int[] nums){
        return quickSort(0, nums.length, nums);
    }
    public int[] quickSort(int left, int right, int[] nums){
        if(left < right){
            int mid = partition(left, right, nums);
            quickSort(left, mid-1, nums);
            quickSort(mid+1, right, nums);
        }
        return nums;
    }
    private Random random = new Random();
    public int partition(int left, int right, int[] nums){
        int a = random.nextInt(right - left + 1);
        swap(left, a, nums);
        int pivot = nums[left];
        int index = left;
        for (int i = left + 1; i < right; i++) {
            if(pivot > nums[i]){
                index ++;
                swap(i, index, nums);
            }
        }
        swap(index,left, nums);
        return index;
    }
    public void swap(int ori, int des, int[] nums){
        int tmp = nums[ori];
        nums[ori] = nums[des];
        nums[des] = tmp;

    }

}
