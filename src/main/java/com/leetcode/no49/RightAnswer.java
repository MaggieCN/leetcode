package com.leetcode.no49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/14
 * @description: 解法二 排序后映射
 * https://leetcode-cn.com/problems/group-anagrams/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--16/
 */
public class RightAnswer {
    public static void main(String[] args) {
        RightAnswer rightAnswer = new RightAnswer();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        rightAnswer.groupAnagrams(strs);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hash = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] s_arr = strs[i].toCharArray();
            //排序
            Arrays.sort(s_arr);
            //映射到 key
            String key = String.valueOf(s_arr);
            //添加到对应的类中
            if (hash.containsKey(key)) {
                hash.get(key).add(strs[i]);
            } else {
                List<String> temp = new ArrayList<String>();
                temp.add(strs[i]);
                hash.put(key, temp);
            }

        }
        return new ArrayList<List<String>>(hash.values());
    }
}
