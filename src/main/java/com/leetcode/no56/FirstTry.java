package com.leetcode.no56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/9
 * @description:
 */
public class FirstTry {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if(len<2) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(o->o[0]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < len ; i++) {
            int[] curInterval = intervals[i];
            int[] peek = list.get(list.size()-1);
            if(curInterval[0] <= peek[1]){
                list.remove(list.size()-1);
                int[] addInterval = {Math.min(curInterval[0],peek[0]),Math.max(curInterval[1],peek[1])};
                list.add(addInterval);
            }else{
                list.add(curInterval);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
    public static void main(String[] args) {
        RightAnswer solution = new RightAnswer();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = solution.merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
