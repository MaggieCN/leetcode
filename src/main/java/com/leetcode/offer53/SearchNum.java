package com.leetcode.offer53;

/**
 * @Author MaggieCN
 * @Date 2021/9/27
 * @Description
 */
public class SearchNum {
    public static void main(String[] args) {
        int[] nums = {2,3,3,4,5};
        int target = 6 ;
        System.out.println(search(nums, target));
    }
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while (left <=right){
            int mid = left + (right - left)/2;
            if(target >=nums[mid]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println("左边为：" + left + " 右边为：" + right);
        int resultRight = left;
        left = 0;
        while (left <=right){
            int mid = left + (right - left)/2;
            if(target >nums[mid]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println("左边为：" + left + " 右边为：" + right);
        int resultLeft = right;
        return resultRight - resultLeft -1;
    }
}
