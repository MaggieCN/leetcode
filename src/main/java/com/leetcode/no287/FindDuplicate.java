package com.leetcode.no287;

/**
 * @Author MaggieCN
 * @Date 2021/11/9
 * @Description
 * 错误答案：错误原因 第二次循环的时候
 * leftCount < rightCount
 * 应该用小于mid 变量累加
 * 变量与mid做比较
 */
public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums ={1,3,4,2,1};
        System.out.println(findDuplicate(nums));
    }
    public static int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = nums.length -1;
        int mid = 0;
        while(left < right){
            mid = left + (right - left) /2;
            int leftCount = 0;
            int rightCount = 0;
            for(int i = 0; i< right; i++){
                if(nums[i] <= mid){
                    leftCount++;
                }else{
                    rightCount++;
                }
            }
            if(leftCount > rightCount){
                right = mid-1;
            }else{
                left = mid + 1;
            }
        }
        return mid;
    }
}
