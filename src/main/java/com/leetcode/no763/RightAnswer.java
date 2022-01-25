package com.leetcode.no763;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/13
 * @description:
 */
public class RightAnswer {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        // 输入字符串的数组
        char[] sArray = s.toCharArray();
        // 记录字符位置的边界数组
        int[] edge = new int[26];

        // 关键步骤1：统计每一个字符最后出现的位置
        for(int i = 0; i < sArray.length; i++){
            edge[sArray[i] - 'a'] = i;
        }


        int last = -1;
        int index = 0;
        // 关键步骤2 ：从头遍历字符，并更新字符的最远出现下标index，
        // 如果找到字符最远出现位置下标index和当前下标i相等了，则找到了分割点
        // a b a b c b a c a
        // edge = [8, 5, 7, 14, 15, 11, 13, 19, 22, 23, 20, 21, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        // i == 0 -> edge[sArray[i] - 'a'] == 8  -> index == 8
        // i == 1 -> edge[sArray[i] - 'a'] == 5  -> index == 8
        // i == 2 -> edge[sArray[i] - 'a'] == 8  -> index == 8
        // i == 3 -> edge[sArray[i] - 'a'] == 5  -> index == 8
        // i == 4 -> edge[sArray[i] - 'a'] == 7  -> index == 8
        // i == 5 -> edge[sArray[i] - 'a'] == 5  -> index == 8
        // i == 6 -> edge[sArray[i] - 'a'] == 8  -> index == 8
        // i == 7 -> edge[sArray[i] - 'a'] == 7  -> index == 8
        // i == 8 -> edge[sArray[i] - 'a'] == 8  -> index == 8   -> res.add(i - last);
        for(int i = 0; i < sArray.length; i++){
            index = Math.max(index,edge[sArray[i] - 'a']);
            if(i == index){
                res.add(i - last);
                last = i;
            }
        }
        return res;
    }
}
