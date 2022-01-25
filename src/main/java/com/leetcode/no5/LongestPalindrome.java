package com.leetcode.no5;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/15
 * @description:
 */
public class LongestPalindrome {
    //没想出来....
    public String longestPalindrome(String s) {
        char[] s_char = s.toCharArray();
        StringBuffer temp = new StringBuffer();
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < s_char.length; i++) {
            if (i == 0){
                temp.append(s_char[i]);
                res.append(s_char[i]);
            }else if(temp.reverse().charAt(0) == s_char[i]){
                res.append(s_char[i]);
            }else{
                if(temp.reverse().charAt(1) == s_char[i]){
                    res.append(s_char[i]);
                }
            }
        }
        return temp.toString();
    }
}
