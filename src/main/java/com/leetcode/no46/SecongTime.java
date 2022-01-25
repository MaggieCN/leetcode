package com.leetcode.no46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/28
 * @description:
 */
public class SecongTime {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        SecongTime test = new SecongTime();
        test.permute(nums);
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] isUsed = new boolean[nums.length];
        LinkedList<Integer> path = new LinkedList<>();
        dfs(res,path, 0, isUsed,nums);
        return res;
    }
    public void dfs(List<List<Integer>> res,
                    LinkedList<Integer> path,
                    int depth,
                    boolean[] isUsed,
                    int[] nums){
        if(depth == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!isUsed[i]){
                path.add(nums[i]);
                isUsed[i] = true;
                dfs(res,path,depth+1,isUsed,nums);
                isUsed[i] = false;
                path.removeLast();
            }
        }
    }
}
