package com.leetcode.no912;
import java.util.Random;
/**
 * @Author MaggieCN
 * @Date 2021/9/9
 * @Description
 */
public class RightAnswer {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5,2,3,1};
        int[] result = solution.sortArray(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
class Solution{
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int low, int high){
        if(low < high){
            int mid = partition(nums, low, high);
            quickSort(nums, low, mid - 1);
            quickSort(nums, mid + 1, high);
        }
    }

//
//    private int partition(int[] nums, int low, int high){
//        int pivot = low + (int) (Math.random() * (high - low + 1));
//        swap(nums, pivot, low);
//        int i = low, j = low + 1;
//        while (j <= high){
//            if(nums[j] < nums[low]){
//                swap(nums, j, ++i);
//            }
//            j++;
//        }
//        swap(nums, low, i);
//        return i;
//    }

    //返回的index代表快排切分完后的下标
    // index左边的nums[i]都比num[index]小
    // index右边的nums[i]都比num[index]大
    public int partition(int[] nums, int left, int right) {
        if (left < right) {
            int a = left + 1 + new Random().nextInt(right - left);
            swap(nums, left, a);
        }
        int pivots = nums[left];
        //index指向比pivot小的元素段的尾部
        int index = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivots) {
                index++;
                swap(nums, index, i);
            }
        }
        swap(nums, index, left);
        return index;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
