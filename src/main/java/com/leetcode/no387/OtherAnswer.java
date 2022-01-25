package com.leetcode.no387;

/**
 * @Author MaggieCN
 * @Date 2021/11/29
 * @Description
 */
public class OtherAnswer {
    public int firstUniqChar(String s){
        int index = -1;
        int len = s.length();
        int[] tmp = new int[26];
        for(int i = 0; i < len ; i++){
            tmp[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < len ; i++){
            if(tmp[s.charAt(i) - 'a']== 1){
                index = i;
                break;
            }
        }
        return index;
    }
}
