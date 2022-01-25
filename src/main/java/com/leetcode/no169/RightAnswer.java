package com.leetcode.no169;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/7
 * @description:
 * 既满足时间复杂度又满足空间复杂度，就要提到位运算中的异或运算 XOR，主要因为异或运算有以下几个特点：
 * 一个数和 0 做 XOR 运算等于本身：a⊕0 = a
 * 一个数和其本身做 XOR 运算等于 0：a⊕a = 0
 * XOR 运算满足交换律和结合律：a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
 * 故而在以上的基础条件上，将所有数字按照顺序做抑或运算，最后剩下的结果即为唯一的数字
 */
public class RightAnswer {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int num: nums) {
            ans ^= num;
        }
        return ans;
    }

}
