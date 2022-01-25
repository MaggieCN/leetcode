package com.leetcode.offer53;

/**
 * @Author MaggieCN
 * @Date 2021/9/27
 * @Description
 */
public class RightAnswer {
    public static void main(String[] args) {
        int[] nums = {2,3,3,3,5};
        int target = 3 ;
        System.out.println(search(nums, target));
    }
    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r){// 查找右边界
            int mid = l + (r-l)/2;
            if(target >= nums[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        // 如果 nums 中不存在 target, 则直接返回 0
        if(l - 1 >= 0 && nums[l - 1] != target) return 0;

        // 如果 nums 中存在 target, 则继续查找左边界
        int right = l;//target 存在，则此时的 l 指向右边界
        l = 0; // 左边界从 [0,right-1]开始查找，由于 r 已经指向了 right - 1, 则只要更新 l 即可
        while (l <= r){
            int mid = l + (r - l)/2;
            if(target > nums[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        int left = r; //循环结束后，r 指向左边界
        return right - left - 1; // 返回结果
    }
}
