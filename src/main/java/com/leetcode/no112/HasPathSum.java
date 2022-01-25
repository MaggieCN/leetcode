package com.leetcode.no112;


//输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//输出：true
//解释：等于目标和的根节点到叶节点路径如上图所示。
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return dfs(root,targetSum,0);
    }
    public boolean dfs(TreeNode curNode, int targetSum, int sum){
        if(curNode == null) return false;
        if(targetSum == sum +curNode.val) return true;
        if(curNode.left == null && curNode.right == null) return false;
        return dfs(curNode.left, targetSum,sum+curNode.val) || dfs(curNode.right, targetSum,sum+curNode.val);
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

