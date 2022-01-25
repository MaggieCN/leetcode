package com.leetcode.no912.fastSort;

import javax.print.attribute.standard.PagesPerMinute;
import java.util.Random;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/29
 * @description:
 */
public class SecondSolution {
    public static void main(String[] args) {
        SecondSolution secondSolution = new SecondSolution();
        int[] nums = {-3,6,2,-5,-4};
        secondSolution.sortArray(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
    public int[] sortArray(int[] nums) {
        return quickSort(0, nums.length-1, nums);
    }
    public int[] quickSort(int left,
                           int right,
                           int[] nums){
        if(left < right){
            int mid = partition(left, right, nums);
            quickSort(left, mid -1, nums);
            quickSort(mid+1, right, nums);
        }
        return nums;
    }
    public Random random = new Random();
    public int partition(int left, int right, int[] nums){
        if(left < right){
            int a = left + 1 +random.nextInt(right - left);
            swap(left, a, nums);
        }
        int pivot = left;
        for (int i = left+1; i <=right ; i++) {
            if(nums[i] < nums[pivot]){
                left ++;
                swap(left, i, nums);
            }
        }
        swap(pivot, left, nums);
        return left;
    }
    public void swap(int left, int right, int[] nums){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
