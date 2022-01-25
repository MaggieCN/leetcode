package com.leetcode.no566;

/**
 * @Author MaggieCN
 * @Date 2021/11/26
 * @Description
 * flatten  拍扁
 * 这样的映射即为：
 * (i,j)→i×n+j
 * 第 x 个元素在 nums 中对应的下标为 (x/n, x/% n)而在新的重塑矩阵中对应的下标为(x / c,x % c)。
 *
 */
public class RightAnswer {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }
        int[][] ans = new int[r][c];
        for (int x = 0; x < m * n; ++x) {
            ans[x / c][x % c] = nums[x / n][x % n];
        }
        return ans;
    }
}
