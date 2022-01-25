package com.leetcode.no56;

import java.util.Arrays;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/8
 * @description: 56. 合并区间
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 错误：[1,4] [5,6] 应该输出为[1,4] [5,6]，但下面代码是【1，6】
 */
public class MergeLeftRight {
    public static void main(String[] args) {
        MergeLeftRight mlr = new MergeLeftRight();
        int[][] intervals = {{1,4},{4,5}};
        int[][] merge = mlr.merge(intervals);
        for (int i = 0; i <merge.length ; i++) {
            for (int j = 0; j < merge[0].length; j++) {
                System.out.println(merge[i][j]);
            }
        }
    }
    //按照left大小插入
    //比较新的left 与原left 以及上一个right
    //如果新的left> 上一个left/是最小的left, 新的right
    public int[][] merge(int[][] intervals) {
        boolean[] array = new boolean[10001];
        int[][] merge = new int[intervals.length][2];
        for (int i = 0; i <intervals.length ; i++) {
            int left = intervals[i][0];
            int right =  intervals[i][1];
            for (int j = left; j <= right ; j++) {
                if(!array[j]){
                    array[j] = true;
                }
            }
        }
        int left = 0 ;
        int right = 0;
        int row = 0;
        for (int i = 0; i <array.length; i++) {
            if(left==0 && array[i]){
                left = i;
            }else if(left !=0 && !array[i] && right ==0){
                right = i;
                merge[row][0] = left;
                merge[row][1] = right-1;
                left = 0;
                right = 0;
                row++;
            }
        }
        int[][] res = Arrays.copyOf(merge,row);
        return res;
    }
}

