package com.leetcode.no240;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/10
 * @description:
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-4/
 */
public class RightAnswer {
    //右上角出发 while
    //https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/sou-suo-er-wei-ju-zhen-ii-cong-you-shang-e0vj/
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 && matrix[0].length == 0) return false;
        int i = 0, j = matrix[0].length - 1;  //矩阵右上角
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) i++;  //排除一行
            else if (matrix[i][j] > target) j--;  //排除一列
        }
        return false;
    }
    //二分法
    // 比如某一行的第一个元素大于了 target ，当前行和后边的所有行都不用考虑了，直接返回 false。
    //某一行的最后一个元素小于了 target ，当前行就不用考虑了，换下一行。
    //https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-4/
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target) {
                break;
            }
            if(matrix[i][matrix[i].length - 1] < target){
                continue;
            }
            int col = binarySearch(matrix[i], target);
            if (col != -1) {
                return true;
            }
        }
        return false;
    }

    //二分查找
    private int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
