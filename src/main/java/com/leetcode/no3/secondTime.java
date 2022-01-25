package com.leetcode.no3;

import java.util.HashMap;

/**
 * @Author MaggieCN
 * @Date 2021/10/21
 * @Description
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * abcabcbb
 * 01234567
 * 0 a start 0 end 1
 * 1 b start 0 end 2
 * 2 c start 0 end 3
 * 3 a start 1 end 4
 * 4 b start 2 end 5
 * 5 c start 3 end 6
 * 6 b start 5 end 7
 * 7 b start 6 end
 */
public class secondTime {
    public static void main(String[] args) {

    }
    public int subLongest(String s){
        if(s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;
        for (int start = 0, end =1; end < s.length(); end++) {
            map.put(s.charAt(start),end-1);
            if(map.containsKey(s.charAt(start))){
                start++;
            }
            result = Math.max(end-start, result);
        }
        return result;
    }
}
