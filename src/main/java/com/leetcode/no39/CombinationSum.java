package com.leetcode.no39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: gaomeiqi
 * @Date: 2022/1/28
 * @description:
 */
public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] nums = {2,3,4,6};
        int target = 7;
        List<List<Integer>> res = combinationSum.combinationSum(nums, target);
        for (int i = 0; i < res.size(); i++) {
            List<Integer> path = res.get(i);
            for (int j = 0; j < path.size(); j++) {
                System.out.print(path.get(j) + ",");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        LinkedList<Integer> path = new LinkedList<>();
        dfs(res, path, candidates, 0, target);
        return res;
    }
    private void dfs(List<List<Integer>> res,
                     LinkedList<Integer> path,
                     int[] candidates,
                     int begin,
                     int sum){
        if(sum < 0 ) return;
        if(sum == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(res, path, candidates, i, sum - candidates[i]);
            path.removeLast();
        }
    }
}
