package com.leetcode.no704;

/**
 * @Author MaggieCN
 * @Date 2021/9/15
 * @Description
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {0,2,3,5,7,9};
        int target = 11;
        int[] nums2 = {-3,6,2,5,-4};
        int[] result = quickSort(nums2,0,nums2.length-1);
        for (int i : result) {
            System.out.println(i);
        }
        //System.out.println(binarySearch(nums, target));
    }
    public static int binarySearch(int[]nums, int target){
        int left = 0;
        int right = nums.length -1;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(target == nums[mid]){
                return mid;
            }else if( target > nums[mid]){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }
        return -1;
    }
    //left i->left+1
    public static int[] quickSort(int[] nums, int left, int right){
        if(left < right){
            int mid = partition(nums,left, right);
            quickSort(nums,left, mid -1);
            quickSort(nums, mid +1, right);
        }
        return nums;
    }
    public static int partition(int[] nums, int left, int right){
        // -3,6,2,5,-4
       // left =0 right=nums.length-1 pivot=-3 index =0
        // i=1
        int pivot = nums[left];
        int index = left;
        for (int i = left + 1; i <= right ; i++) {
            if(nums[i] < pivot){
                index ++;
                swap(nums,index,i);
            }
        }
        swap(nums,index,left);
        return index;
    }
    public static void swap(int[] nums, int left, int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
