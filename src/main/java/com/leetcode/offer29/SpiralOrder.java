package com.leetcode.offer29;

/**
 * @Author MaggieCN
 * @Date 2021/10/13
 * @Description 顺时针打印矩阵
 */
public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0 && matrix[0].length == 0) return null;
        int originRow = matrix.length;
        int originColumn = matrix[0].length;
        int[] result = new int[originRow*originColumn];
        int startRow = 0;
        int endRow = originRow;
        int startColumn = 0;
        int endColumn = originColumn;
        int transform = 0;
        int lastRow, lastColumn =0;
        while(startRow<=endRow && startColumn<=endColumn){
            for (int i = 0; i < result.length ; i++) {
                if(transform ==0) result[i] = matrix[startRow][startColumn++];
                else if(transform == 1) result[i] = matrix[startRow++][endColumn];
                else if(transform == 2) result[i] = matrix[endRow+1][endColumn--];
                if(startColumn == originColumn){
                    transform = 1;
                    startColumn = 0;
                    endColumn --;
                }
                if(startRow == originRow){
                    transform = 2;
                    startRow = 0;
                    endRow --;
                }
                if(endRow == 0){
                    transform = 2;
                    startRow = 0;
                    endRow --;
                }
                if(endColumn == 0){
                    transform = 2;
                    startRow = 0;
                    endRow --;
                }
            }
        }
        return result;
    }
}
