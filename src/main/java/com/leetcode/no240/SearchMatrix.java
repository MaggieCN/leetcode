package com.leetcode.no240;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/10
 * @description:
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //从右上角出发 1.等于-返回 2. 小于 只可能在左侧，当行左侧继续搜索 3.大于，只可能在下侧，所以break跳出forj的循环
        int row = matrix.length -1;
        int col = matrix[0].length -1;
        for (int i = 0; i <=row ; i++) {
            for (int j = col; j >=0 ; j--) {
                System.out.println(matrix[i][j]);
                if(target == matrix[i][j]) return true;
                else if(target < matrix[i][j]) continue;
                else break;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
        int[][] matric = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchMatrix.searchMatrix(matric, 14));
    }
}
