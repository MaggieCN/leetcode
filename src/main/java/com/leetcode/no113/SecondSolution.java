package com.leetcode.no113;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: gaomeiqi
 * @Date: 2022/1/6
 * @description:
 */
public class SecondSolution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(res, path, targetSum, root);
        return res;
    }
    public void dfs(List<List<Integer>> res, LinkedList<Integer> path, int sum, TreeNode root){
        if(root == null) return;
        path.add(new Integer(root.val));
        if(root.left == null && root.right == null){
            if(sum - root.val == 0){
                res.add(new LinkedList<>(path));
            }
            path.remove(path.size()-1);
            return;
        }
        dfs(res, path, sum-root.val, root.left);
        dfs(res, path, sum-root.val, root.right);
        path.remove(path.size()-1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
