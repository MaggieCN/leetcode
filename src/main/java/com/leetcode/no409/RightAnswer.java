package com.leetcode.no409;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/14
 * @description:
 */
public class RightAnswer {
    //将每个字符使用偶数次，使得它们根据回文中心对称。在这之后，如果有剩余的字符，我们可以再取出一个，作为回文中心
    public int longestPalindrome(String s) {
        int res = 0;
        int[] count = new int[128];
        for (int i = 0; i <s.length() ; i++) {
            char c=  s.charAt(i);
            count[c-'A'] +=1;
        }
        for (int i = 0; i <count.length ; i++) {
            res += count[i]/2 *2;
            if(res %2 == 0 && count[i]%2 == 1){
                res++;
            }
        }
        return res;
    }

}
