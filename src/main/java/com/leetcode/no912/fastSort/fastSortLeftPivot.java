package com.leetcode.no912.fastSort;

/**
 * @Author MaggieCN
 * @Date 2021/11/11
 * @Description
 */
public class fastSortLeftPivot {
    /* 快速排序
        快排是不稳定的排序
        随机选取一个数作为基准进行比较，小的放在基准数前，大的放在基准数后，重复以上过程
        复杂度情况好时是 nlogn, 差的时候是n^2
     */
    public static void main(String[] args) {
        int[] nums = {-3,6,2,-5,-4};
        sortArray(nums);
    }
    public static int[] sortArray(int[] nums) {
        return quickSort(nums,0,nums.length-1);
    }
    public static int[] quickSort(int[] nums, int left, int right){
        //在左右指向趋向边界的时候，跳出终止递归
        if(left < right){
            int mid = partition(nums,left, right);
            quickSort(nums,left, mid -1);
            quickSort(nums, mid +1, right);
        }
        return nums;
    }
    public static int partition(int[] nums, int left, int right){
        // -3, 6, 2, -5, -4  pivot: -3, index: 0
        // -3, -5, 2, 6, -4  pivot: -3, index: 1  i:3 交换nums[1] nums[3]
        // -3, -5, -4, 6, 2  pivot: -3, index: 2  i:4 交换nums[2] nums[4]
        // 这样保证交换后的比pivot小的数在pivot右侧
        // 再交换nums[index] nums[left]
        // -4, -5, -3, 6, 2  基准值就在中间位置了，比-3小的在左侧，比-3大的在右侧
        int pivot = nums[left];
        int index = left;
        for (int i = left + 1; i <= right ; i++) {
            if(nums[i] < pivot){
                index ++;
                swap(nums,index,i);
            }
        }
        swap(nums,index,left);
        return index;
    }
    public static void swap(int[] nums, int left, int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
