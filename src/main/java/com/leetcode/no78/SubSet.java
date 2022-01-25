package com.leetcode.no78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author MaggieCN
 * @Date 2021/11/6
 * @Description
 */
public class SubSet {
    //first-try
    /*
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result,new LinkedList<>(), nums, 0);
        return result;
    }
    public void dfs(List<List<Integer>> result, LinkedList<Integer> path, int[] nums, int start){
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(result, path, nums, start + 1);
            path.remove(i);
        }
    }
    */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(res, path, 0, nums);
        return res;
    }
    public void dfs(List<List<Integer>> res, LinkedList<Integer> path, int start, int[] nums){
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(res, path, i +1, nums);
            path.removeLast();
        }
    }
}
