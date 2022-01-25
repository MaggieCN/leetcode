package com.leetcode.no118;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author MaggieCN
 * @Date 2021/11/26
 * @Description
 */
public class Trangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> lastLevel = new ArrayList<>();
        lastLevel.add(1);
        res.add(lastLevel);
        for (int i = 1; i < numRows ; i++) {
            List<Integer> level = new ArrayList<>();
            level.add(1);
            for (int j = 0; j < i - 1; j++) {
                level.add(lastLevel.get(j)+lastLevel.get(j+1));
            }
            level.add(1);
            res.add(level);
            lastLevel = level;
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 5;
        generate(num);
    }
}
