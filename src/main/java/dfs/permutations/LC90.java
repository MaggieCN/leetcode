package dfs.permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: gaomeiqi
 * @Date: 2022/1/27
 * @description: 90. 子集 II
 * https://leetcode-cn.com/problems/subsets-ii/
 */
public class LC90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       List<List<Integer>> res = new ArrayList<>();
       boolean[] isUsed = new boolean[nums.length];
       LinkedList<Integer> path = new LinkedList<>();
       dfs(res, path, 0, nums, isUsed, 0);
       return res;
    }
    private void dfs(List<List<Integer>> res,
                     LinkedList<Integer> path,
                     int depth,
                     int[] nums,
                     boolean[] isUsed,
                     int begin){
        res.add(new LinkedList<>(path));
        if(depth == nums.length) return;
        for (int i = begin; i < nums.length ; i++) {
            if(i> 0 && nums[i] == nums[i-1] && !isUsed[i-1])
                continue;
            if(!isUsed[i]){
                path.add(nums[i]);
                isUsed[i] = true;
                dfs(res, new LinkedList<>(path), depth + 1, nums, isUsed, i+1);
                System.out.println(("第" + depth + "层的isUsed" + "是" + isUsed[0] + "," + isUsed[1] + "," + isUsed[1]));
                path.removeLast();
                isUsed[i] = false;
            }
        }
    }
}
