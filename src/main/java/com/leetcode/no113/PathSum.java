package com.leetcode.no113;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/24
 * @description:
 */
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res =  new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(res, path, root, targetSum);
        return res;
    }
    public void dfs(List<List<Integer>> res, LinkedList<Integer> path, TreeNode root, int sum){
        if(root == null) return;
        LinkedList<Integer> list = new LinkedList<>(path);
        list.add(new Integer(root.val));
        if(root.left == null && root.right == null) {
            if (sum == root.val){
               res.add(list);
            }
            list.remove(list.size()-1);
            return;
        }
        dfs(res, list, root.left, sum- root.val);
        dfs(res, list, root.right, sum- root.val);
        list.remove(list.size()-1);
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
