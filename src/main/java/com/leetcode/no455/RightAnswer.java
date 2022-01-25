package com.leetcode.no455;

import java.util.Arrays;

/**
 * @Author MaggieCN
 * @Date 2021/11/19
 * @Description 贪心算法
 * https://leetcode-cn.com/problems/assign-cookies/solution/455-fen-fa-bing-gan-tan-xin-jing-dian-ti-o6k6/
 * g[] 小孩子胃口 s[] 小饼干的大小
 */
public class RightAnswer {
    public static void main(String[] args) {
        int[] g = {1,3,7,10};
        int[] s = {1,3,8,9};
        findContentChildren(g,s);
    }
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int start = 0;
        int count = 0;
        for (int i = 0;
             i < s.length && start < g.length;
             i++) {
            if (s[i] >= g[start]) {
                start++;
                count++;
            }
        }
        return count;
    }
}
