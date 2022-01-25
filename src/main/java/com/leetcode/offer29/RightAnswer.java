package com.leetcode.offer29;

/**
 * @Author MaggieCN
 * @Date 2021/10/13
 * @Description
根据题意，需要特判，对于空矩阵直接返回空数组。
接下来：
定义出二维数组的左右上下四个边界，left、right、top、bottom;
循环打印：
沿着top，从左向右打印，top++;
沿着right,从上向下打印，right--;
沿着bottom，从右向左打印，bottom++；
沿着left,从下向上打印，left++;
注：在沿着下边界和左边界打印时，要确保left <= right，top <= bottom。

 */
public class RightAnswer {
    public int[] spiralOrder(int[][] matrix) {
        //特判
        if(matrix == null ||matrix.length == 0){
            return new int[0];
        }

        //初始化
        int left = 0, top = 0;
        int right = matrix[0].length-1;
        int bottom = matrix.length - 1;
        int[] res = new int[(right+1)*(bottom+1)];
        int k = 0;

        //循环打印
        while(top <= bottom && left <= right){
            for(int i = left; i <= right; i++){ //从左到右
                res[k++] = matrix[top][i];
            }
            top ++;
            for(int i = top; i <= bottom; i++){ //从上到下
                res[k++] = matrix[i][right];
            }
            right --;
            for(int i = right; i >= left && top <= bottom; i--){    //从右到左
                res[k++] = matrix[bottom][i];
            }
            bottom --;
            for(int i = bottom; i >= top && left <= right; i--){    //从下到上
                res[k++] = matrix[i][left];
            }
            left ++;
        }
        return res;
    }
}
