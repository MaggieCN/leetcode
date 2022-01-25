package com.leetcode.no46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author MaggieCN
 * @Date 2021/11/10
 * @Description
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * false false false 1
 * 2
 * 3
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] isUsed = new boolean[nums.length];
        LinkedList<Integer> path = new LinkedList<>();
        dfs(res, path, 0, isUsed, nums);
        return res;
    }
    public void dfs(List<List<Integer>> res,
                    LinkedList<Integer> path,
                    int depth,
                    boolean[] isUsed,
                    int[] nums){
        if(depth == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!isUsed[i]){
                path.add(nums[i]);
                isUsed[i] = true;
                dfs(res, path, depth+1, isUsed, nums);
                path.removeLast();
                isUsed[i] = false;
            }
        }
    }
}
