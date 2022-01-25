package com.leetcode.offer04;

/**
 * @Author MaggieCN
 * @Date 2021/9/7
 * @Description 二维数组中的查找
 * 在一个 n * m 的二维数组中，
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class findNumberIn2DArray {
    public static void main(String[] args) {

    }
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length;
        int j = 0;
        int flag = matrix[matrix.length][0];
        while (i > 0 && j < matrix[0].length ){
            if(flag > target) i--;
            else if(flag < target) i++;
            else if (flag == target) return true;
        }
        return false;
    }
}
