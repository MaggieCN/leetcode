package com.leetcode.no34;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author MaggieCN
 * @Date 2021/10/28
 * @Description
 */
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(new ArrayList<>(),root,target, result);
        return result;
    }
    public void dfs(List<Integer> list, TreeNode root, int sum, List<List<Integer>> result){
        if(root == null) return;
        List<Integer> subList = new ArrayList<>(list);
        subList.add(new Integer(root.val));
        if(root.left == null && root.right == null){
            if(sum == root.val){
                result.add(subList);
            }
            return;
        }
        dfs(subList,root.left,sum-root.val, result);
        dfs(subList,root.right,sum-root.val, result);
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
