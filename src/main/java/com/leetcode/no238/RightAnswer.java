package com.leetcode.no238;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/13
 * @description: 矩阵（上三角、下三角）
 * https://leetcode-cn.com/problems/product-of-array-except-self/solution/product-of-array-except-self-shang-san-jiao-xia-sa/
 * 原数组：       [5       2       3        4]
 * 左部分的乘积：   1      1*5      1*5*2    1*5*2*3
 * 右部分的乘积： 2*3*4    3*4      4        1
 * 结果：       1*2*3*4  1*5*3*4  1*5*2*4  1*5*2*3*1
 */
public class RightAnswer {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int p = 1, q = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = p;
            p *= nums[i];
        }
        for (int i = nums.length - 1; i > 0 ; i--) {
            q *= nums[i];
            res[i - 1] *= q;
        }
        return res;
    }

    public static void main(String[] args) {
        RightAnswer rightAnswer = new RightAnswer();
        int[] nums = {5,2,3,4};
        rightAnswer.productExceptSelf(nums);
    }
}
