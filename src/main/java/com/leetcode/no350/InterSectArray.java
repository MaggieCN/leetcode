package com.leetcode.no350;

import java.util.Arrays;

/**
 * @Author MaggieCN
 * @Date 2021/11/25
 * @Description
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/solution/ha-xi-biao-liang-ge-shu-zu-de-jiao-ji-ii-fkwo/
 * 创建一个指针 i 指向 nums1 数组首位，指针 j 指向 nums2 数组首位。
 * 创建一个临时栈，用于存放结果集。
 * 开始比较指针 i 和指针 j 的值大小，若两个值不等，则数字小的指针，往右移一位。
 * 若指针 i 和指针 j 的值相等，则将交集压入栈。
 * 若 nums1 或 nums2 有一方遍历结束，代表另一方的剩余值，都是唯一存在，且不会与之产生交集的。
 */
public class InterSectArray {
    public static int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length - 1;
        int len2 = nums2.length - 1;
        int minLen = len1 < len2 ? len1 +1 : len2 +1;
        int i = 0;
        int j = 0;
        int[] res = new int[minLen];
        int m = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (i <= len1 && j <= len2) {
            if(nums1[i] == nums2[j]){
                res[m] = nums1[i];
                m++;
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        return Arrays.copyOfRange(res, 0, m); // 必须用这个，要不剩余未填充的会自动填充0
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        for (int i : intersect(nums1, nums2)) {
            System.out.println(i);
        }
    }
}
