package com.leetcode.no912;

import java.util.Arrays;

/**
 * @Author MaggieCN
 * @Date 2021/11/11
 * @Description
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {2,12,3,7,6,5};
        sortArray(nums);
    }
    public static int[] sortArray(int[] nums) {

        /* 冒泡排序
            冒泡是稳定的排序
            比较相邻的两个数，如果前一个比后一个大，就置换
            一直循环到最后一个数
            重复以上过程， 复杂度为n^2
         */
        // 对 arr 进行拷贝，不改变参数内容
        int[] res = Arrays.copyOf(nums, nums.length);
        for (int i = 1; i < res.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;
            for (int j = 0; j < res.length-1; j++) {
                if(res[j] > res[j+1]){
                    int tmp = res[j];
                    res[j] = res[j+1];
                    res[j+1] = tmp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
        return res;
    }
}
