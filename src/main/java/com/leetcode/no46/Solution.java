package com.leetcode.no46;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author MaggieCN
 * @Date 2021/10/29
 * @Description
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        System.out.println("第"+ " "+ depth + "次dfs => " );
        for (int i = 0; i < len; i++) {
            System.out.println(i+ "递归之前 used => " + used[0] + "," + used[1] + "," + used[2] );
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;
                System.out.println("递归之前 i => " + i);
                System.out.println("递归之前 path => " + path);
                dfs(nums, len, depth + 1, path, used, res);
                used[i] = false;
                System.out.println("递归之后 i => " + i);
                System.out.println("递归之后 used => " + used[0] + "," + used[1] + "," + used[2] );
                path.removeLast();
                System.out.println("递归之后 => " + path);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }
}
