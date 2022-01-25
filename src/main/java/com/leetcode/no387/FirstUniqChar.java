package com.leetcode.no387;

import java.util.HashMap;

/**
 * @Author MaggieCN
 * @Date 2021/11/29
 * @Description
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        if(s.length() == 0) return -1;
        int[] tmp = new int[26];
        for (int i = 0; i<s.length(); i++){
            tmp[s.charAt(i) - 'a']++;
        }
        //最开始的时候写成 i< tmp.length 所以有问题
        for (int i = 0; i < s.length(); i++) {
            if(tmp[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
    public static int firstUniqChar1(String s) {
        if(s.length() == 0) return -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() ; i++) {
            Character ch = s.charAt(i);
            if(map.get(ch) == null) map.put(ch,i);
            else map.put(ch,-1);
        }
        int first = s.length();
        for (int i = 0; i < s.length() ; i++) {
            Character ch = s.charAt(i);
            int a = map.get(ch);
            if(map.get(ch) != -1 && map.get(ch) < first){
                first = map.get(ch);
            }
        }
        if(first == s.length()){
            first = -1;
        }
        return first;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        firstUniqChar1(s);
    }
}
