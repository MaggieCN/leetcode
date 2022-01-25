package com.leetcode.no49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/14
 * @description:
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i <strs.length ; i++) {
            char[] str_c = strs[i].toCharArray();
            Arrays.sort(str_c);
            String key = String.valueOf(str_c);
            if(map.containsKey(key)){
                map.get(key).add(strs[i]);
            }else{
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(key,temp);
            }
        }
        return new ArrayList<>(map.values());
    }
}
