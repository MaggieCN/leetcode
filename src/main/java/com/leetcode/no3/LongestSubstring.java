package com.leetcode.no3;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author MaggieCN
 * @Date 2021/10/14
 * @Description 无重复的最长子串
 */
public class LongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcaa";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap();
        for (int start = 0, end =0; end < s.length() ; end++) {
            Character c = s.charAt(end);
            if(map.containsKey(c)){
                start = Math.max(start, map.get(c)+1);
            }
            ans = Math.max(ans, end-start +1);
            //abcabcaa 第七位 a的时候会更新start为7， 此时end也为7，ans结果就是1，表示的不是最大长度
            //ans =  end-start +1;
            map.put(c,end);
        }
        return ans;
    }
}
