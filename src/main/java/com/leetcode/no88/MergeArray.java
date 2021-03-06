package com.leetcode.no88;

/**
 * @Author MaggieCN
 * @Date 2021/11/24
 * @Description
 */
public class MergeArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m-1;
        int len2 = n-1;
        int len = m+n-1;
        while(len1 >= 0 && len2 >=0){
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
    }
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m =3;
        int n =3;
        merge(nums1, m, nums2, n);
    }
}
