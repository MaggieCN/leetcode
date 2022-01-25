package com.leetcode.no47;

import java.util.*;

/**
 * @Author MaggieCN
 * @Date 2021/11/3
 * @Description
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] isUsed = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(result, new LinkedList<>(), nums, 0, isUsed);
        return result;
    }
    public void dfs(List<List<Integer>> result, LinkedList<Integer> path,
                    int[] nums, int depth, boolean[] isUsed){
        if(depth == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(isUsed[i]) continue;
            if(i > 0 && nums[i] == nums[i-1] && !isUsed[i-1]){
                continue;
            }
            path.add(new Integer(nums[i]));
            isUsed[i] = true;
            dfs(result, path, nums, depth +1, isUsed);
            path.removeLast();
            isUsed[i] = false;
        }
    }
}
