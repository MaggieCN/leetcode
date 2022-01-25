package com.leetcode.no383;

import java.util.HashMap;

/**
 * @Author MaggieCN
 * @Date 2021/11/29
 * @Description
 */
public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;
        int[] tmp = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            tmp[magazine.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            tmp[ransomNote.charAt(i) - 'a'] --;
        }
        for (int i = 0; i < tmp.length; i++) {
            if(tmp[i]<0){
                return false;
            }
        }
        return true;
    }
}
