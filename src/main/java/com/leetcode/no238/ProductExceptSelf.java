package com.leetcode.no238;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/13
 * @description:
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int left=1, right=1;
        for (int i = 0; i < nums.length; i++) {
           //写错left *=nums[i];res[i] *=left;
            res[i] = left;
            left *=nums[i];
        }
        for (int i = nums.length-1; i >0 ; i--) {
            right *=nums[i];
            res[i-1] *=right;
        }
        return res;
    }

    public static void main(String[] args) {
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        int[] nums = {5,2,3,4};
        productExceptSelf.productExceptSelf(nums);
    }
}
