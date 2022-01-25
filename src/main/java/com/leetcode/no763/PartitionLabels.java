package com.leetcode.no763;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/13
 * @description:
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] arrayCha = new int[26];
        char[] originCha = s.toCharArray();
        for (int i = 0; i <originCha.length ; i++) {
            arrayCha[originCha[i] - 'a'] = i;
        }
        int index = 0;
        int last = -1;
        for (int i = 0; i < originCha.length; i++) {
            index = Math.max(index,arrayCha[originCha[i] - 'a']);
            if(i == index){
                res.add(index - last);
                last = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        List<Integer> res = partitionLabels.partitionLabels("ababcbacadefegdehijhklij");
        for (int i = 0; i < res.size() ; i++) {
            System.out.println(res.get(i));
        }
    }
}
