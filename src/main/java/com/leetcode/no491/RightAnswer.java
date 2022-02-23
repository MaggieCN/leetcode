package com.leetcode.no491;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: gaomeiqi
 * @Date: 2022/2/11
 * @description:
 */
public class RightAnswer {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    public void dfs(int cur, int pre, int[] nums) {
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        if (nums[cur] >= pre) {
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }
        if (nums[cur] != pre) {
            dfs(cur + 1, pre, nums);
        }
    }
}
