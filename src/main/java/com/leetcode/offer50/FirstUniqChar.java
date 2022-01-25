package com.leetcode.offer50;

import java.util.HashMap;

/**
 * @Author MaggieCN
 * @Date 2021/9/29
 * @Description 字符串中，第一个第一次出现的字符
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        String s="aabbcddfg";
        System.out.println(firstUniqChar(s));
    }
    public static char firstUniqChar(String s) {
        //定义一个HashMap, Character存放字符，Integer存放字符出现次数
        //getOrDefault()方法：getOrDefault(Object key, V value),key 存在，返回该key的value，如果不存在返回defaultValue
        //Character是类(有属性和方法)，char基本数据类型.
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i <s.length() ; i++) {
            Character c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(map.get(c)==1) return c;
        }
        return ' ';
    }
}
