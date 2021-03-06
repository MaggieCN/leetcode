package com.leetcode.no242;

/**
 * @Author MaggieCN
 * @Date 2021/11/29
 * @Description
 */
public class RightAnswer {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] tmp = new int[26];
        for (int i = 0; i < s.length() ; i++) {
            tmp[s.charAt(i)-'a']++;
            tmp[t.charAt(i)-'a']--;
        }
        for (int i = 0; i < tmp.length ; i++) {
            if(tmp[i] == 0) continue;
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        isAnagram(s,t);
    }
}
