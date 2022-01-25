package com.leetcode.no242;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author MaggieCN
 * @Date 2021/11/29
 * @Description
 * 链接：https://leetcode-cn.com/problems/valid-anagram/solution/hua-jie-suan-fa-242-you-xiao-de-zi-mu-yi-wei-ci-by/
 * 首先判断两个字符串长度是否相等，不相等则直接返回 false
 * 若相等，则初始化 26 个字母哈希表，遍历字符串 s 和 t
 * s 负责在对应位置增加，t 负责在对应位置减少
 * 如果哈希表的值都为 0，则二者是字母异位词
 */
public class IsAnagram {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() ; i++) {
            map.put(s.charAt(i),map.get(s.charAt(i)) ==null? 1:map.get(s.charAt(i))+1);
            map.put(t.charAt(i),map.get(t.charAt(i)) ==null? -1:map.get(t.charAt(i))-1);
        }
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) !=0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}
