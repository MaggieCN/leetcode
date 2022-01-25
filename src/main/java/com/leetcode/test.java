package com.leetcode;

/**
 * @Author MaggieCN
 * @Date 2021/9/18
 * @Description
 */
public class test {
    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        int result = findRepeatNumber(nums);
        System.out.println(result);
    }
    public static int findRepeatNumber(int[] nums) {
        int[] result = quickSort(nums, 0, nums.length -1);
        for (int i : result) {
            System.out.print(i+",");
        }
        for(int i = 0 ; i< result.length-1; i++){
            if(result[i] == result[i+1]){
                return result[i];
            }
        }
        return 0;
    }
    public static int[] quickSort(int[] nums, int left, int right){
        if(left<right){
            int mid = partition(nums,left,right);
            quickSort(nums,left,mid -1);
            quickSort(nums,mid + 1,right);
        }
        return nums;
    }
    public static int partition (int[] nums, int left, int right){
        int pivot = nums[left];
        int index = left;
        for(int i = left+1; i<= right; i++){
            if(nums[i] < pivot){
                index ++;
                swap(nums, index, i);
            }
        }
        swap(nums, index, left);
        return index;
    }
    public static void swap(int[] nums, int left, int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}

