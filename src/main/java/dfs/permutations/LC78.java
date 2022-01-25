package dfs.permutations;

import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * @author: gaomeiqi
 * @Date: 2022/1/25
 * @description: 78 子集
 * https://leetcode-cn.com/problems/subsets/
 */
public class LC78 {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        boolean[] isUsed = new boolean[len];
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(res, path, nums, isUsed, 0, 0);
        return res;
    }
    private void dfs(List<List<Integer>> res,
                     LinkedList<Integer> path,
                     int[] nums,
                     boolean[] isUsed,
                     int depth,
                     int cur){
        res.add(new LinkedList<>(path));
        if(depth == nums.length){
            return;
        }
        for (int i = cur; i < nums.length; i++) {
            if(!isUsed[i]){
                path.add(nums[i]);
                isUsed[i] =true;
                dfs(res, path, nums, isUsed, depth+1, i+1);
                path.removeLast();
                isUsed[i] = false;
            }
        }
    }
}
class Solution{
    /*
    更好的写法，不需要记录是否已用，不需要回溯，只要开始是比它小的即可
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, 0, path);
        return res;
    }

    void dfs(int[] nums, int begin, Deque<Integer> path){
        res.add(new ArrayList<>(path));
        if(path.size() == nums.length) return;

        for(int i = begin; i < nums.length; i++){
            path.add(nums[i]);
            dfs(nums, i+1, path);
            path.removeLast();
        }
    }
}
