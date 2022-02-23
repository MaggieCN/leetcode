package com.leetcode.no491;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: gaomeiqi
 * @Date: 2022/2/11
 * @description:
 */
public class FindSubsequences {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return res;
    }
    public void dfs(int cur, int pre, int[] nums){
        if(cur == nums.length){
            if(temp.size() > 1)
                res.add(new ArrayList<>(temp));
            return;
        }
        if(nums[cur] >= pre){
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }
        if(nums[cur]!=pre){
            dfs(cur + 1, pre, nums);
        }
    }
}
