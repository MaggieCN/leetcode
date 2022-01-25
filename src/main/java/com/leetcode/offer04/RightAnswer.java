package com.leetcode.offer04;

/**
 * @Author MaggieCN
 * @Date 2021/9/7
 * @Description 二叉搜索树 将矩阵逆时针旋转 45°
 * 对于每个元素，其左分支元素更小、右分支元素更大
 * 从矩阵 matrix 左下角元素（索引设为 (i, j) ）开始遍历，并与目标值对比：
 * 当 matrix[i][j] > target 时，执行 i-- ，即消去第 i 行元素；
 * 当 matrix[i][j] < target 时，执行 j++ ，即消去第 j 列元素；
 * 当 matrix[i][j] = target 时，返回 true ，代表找到目标值。
 */
public class RightAnswer {
    public static void main(String[] args) {

    }
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) i--;
            else if (matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }
}

