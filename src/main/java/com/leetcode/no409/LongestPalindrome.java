package com.leetcode.no409;

import java.util.HashMap;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/14
 * @description:
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("ababababa"));
    }
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c) + 1);
            }else{
                map.put(c,1);
            }
        }
        if(map.size() == 1){
            return s.length();
        }
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            int curCount = map.get(s.charAt(i));
            if(index == 0 && curCount == 1){
                index ++;
                count ++;
            }
            if(curCount % 2 == 0){
                count += curCount;
            }else {
                count += curCount-1;
            }
            map.put(s.charAt(i),0);
        }
        return count;
    }
}
