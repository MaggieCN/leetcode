package com.leetcode.no290;

import java.util.HashMap;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/13
 * @description:
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        //s字符串按空格拆分成字符串数组
        String[] array = s.split(" ");
        //HashMap 存储key为pattern 的每个字符，value是按索引遍历的array数组
        HashMap<Character,String> map = new HashMap<>();
        /**
         * 1.如果长度不等肯定不符合pattern
         * 2.如果长度为0 长度相同，肯定返回true
         */
        if(pattern.length()!=array.length) return false;
        if(pattern.length() == 0) return true;
        /**for循环，存入map并且比较
         * 1. key存在
         * 1.1 之前存入的value和当前的arrayCur不相等，返回false
         * 1.2 相等，继续
         * 2. key不存在
         *  判断value是否有存在，避免"abba"  "dog dog dog dog"的情况
         * 2.1 存在value,比如第一个b, 之前存a的时候已经有dog这一value了,返回false
         * 2.2 不存在 (key,array[i])添加到map中
         *
         */
        for (int i = 0; i < pattern.length() ; i++) {
            Character pat = pattern.charAt(i);
            String arrayCur = array[i];
            if(map.get(pat) !=null){
                if(!map.get(pat).equals(arrayCur)) return false;
            }else{
                if(map.containsValue(arrayCur)) return false;
                map.put(pat,arrayCur);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        String pattern = "abba";
        String str = "dog dog dog dog";
        System.out.println(wordPattern.wordPattern(pattern, str));
    }
}
