package com.leetcode.no56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/8
 * @description:
 * https://leetcode-cn.com/problems/merge-intervals/solution/tan-xin-suan-fa-java-by-liweiwei1419-3/
 * 经验：区间类的问题，一般而言是需要画图思考的。因为只有建立直观的感觉，才能更有效的去思考解决问题的方案。
 *
 * 还有需要画图思考的相关算法问题有（其实绝大部分都需要打草稿，大神除外）：
 *
 * 和物理现象相关的：第 42 题：接雨水问题、第 11 题：盛最多水的容器、第 218 题：天际线问题；
 * 本身问题描述就和图形相关的问题：第 84 题：柱状图中最大的矩形；
 * 链表问题：穿针引线如果不画图容易把自己绕晕；
 * 回溯算法问题：根据示例画图发现每一步的选择和剪枝的条件；
 * 动态规划问题：画示意图发现最优子结构。
 * 得出结论：可以被合并的区间一定是有交集的区间，前提是区间按照左端点排好序，这里的交集可以是一个点（例如例 2）。
 *
 * 至于为什么按照左端点升序排序，这里要靠一点直觉猜想，我没有办法说清楚是怎么想到的，有些问题的策略是按照右端点升序排序（也有可能是降序排序，具体问题具体分析）。
 *
 * 接着说，直觉上，只需要对所有的区间按照左端点升序排序，然后遍历。
 *
 * 如果当前遍历到的区间的左端点 > 结果集中最后一个区间的右端点，说明它们没有交集，此时把区间添加到结果集；
 * 如果当前遍历到的区间的左端点 <= 结果集中最后一个区间的右端点，说明它们有交集，此时产生合并操作，即：对结果集中最后一个区间的右端点更新（取两个区间的最大值）。
 *
 */
public class RightAnswer {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) {
            return intervals;
        }
        // 按照左侧起点starti排序，lambda表达式
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        //Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        // 也可以使用 Stack，因为我们只关心结果集的最后一个区间
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i = 1; i < len; i++) {
            int[] curInterval = intervals[i];

            // 每次新遍历到的列表与当前结果集中的最后一个区间的末尾端点进行比较
            int[] peek = res.get(res.size() - 1);
            //当前节点的左起点，比peek最大的右终点还大，那直接加入该二维数组即可。
            if (curInterval[0] > peek[1]) {
                res.add(curInterval);
            } else {
                // 注意，这里应该取最大
                peek[1] = Math.max(curInterval[1], peek[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
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
