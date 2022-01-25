package com.leetcode.no287;

/**
 * @Author MaggieCN
 * @Date 2021/11/9
 * @Description 抽屉原理
 * n + 1 个整数，放在长度为 n 的数组里，根据「抽屉原理」，至少会有 1 个整数是重复的；
 * 二分查找的思路是先猜一个数（有效范围 [left..right] 里位于中间的数 mid）
 * 然后统计原始数组中 小于等于 mid 的元素的个数 cnt：
 *
 * 如果 cnt 严格大于 mid。根据抽屉原理，重复元素就在区间 [left..mid] 里；
 * 否则，重复元素就在区间 [mid + 1..right] 里。
 */
public class RightAnswer {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int mid = left + (right - left) /2;
            int count = 0;
            for(int i = 0; i< len; i++){
                if(nums[i] <= mid){
                    count++;
                }
            }
            if(count > mid){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}
