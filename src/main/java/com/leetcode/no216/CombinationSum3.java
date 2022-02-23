package com.leetcode.no216;

import testAnnual.Solution20211113.SolutionDfsSecond;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: gaomeiqi
 * @Date: 2022/2/9
 * @description:
 */
public class CombinationSum3 {
    public static void main(String[] args) {
        CombinationSum3 solutionDfsSecond = new CombinationSum3();
        solutionDfsSecond.combinationSum3(3, 7);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path =  new ArrayDeque<>();
        dfsCombinationSum3(res, path, 0, k, n, 1);
        return res;
    }
    public void dfsCombinationSum3(List<List<Integer>> res,
                                   Deque<Integer> path,
                                   int depth,
                                   int k,
                                   int target,
                                   int begin){
        if(target == 0 && depth == k){
            res.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 || depth >= k) return;
        for (int i = begin; i < 10 ; i++) {
            path.add(i);
            dfsCombinationSum3(res, path, depth + 1, k, target - i, i + 1);
            path.removeLast();
        }
    }
}
