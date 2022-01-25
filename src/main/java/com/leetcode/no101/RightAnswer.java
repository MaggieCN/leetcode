package com.leetcode.no101;

import java.util.LinkedList;

/*
    题目整体思路是把左子树的右节点和右子树的左节点同时压入队列中，再同时出队列比较
    当左子树和右子树都为空时，循环或者迭代结束,返回true
    当其中一个为空或者两个节点值不相等，返回false
 */
public class RightAnswer {

    /*
    1. 递归：dfs的思想
    剪枝的条件：(1)当左子树和右子树都为空时，循环或者迭代结束
              (2)当其中一个为空或者两个节点值不相等，返回false
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return dfsTreeNode(root.left,root.right);
    }
    public boolean dfsTreeNode(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null || left.val!=right.val){
            return false;
        }
        return dfsTreeNode(left.right, right.left) && dfsTreeNode(left.left, right.right);
    }
    /*
    2. 迭代：队列的思想
 */
    public boolean isSymmetric1(TreeNode root) {
        if(root == null) return true;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root.left);
        list.add(root.right);
        while (!list.isEmpty()){
            TreeNode node1 = list.poll();
            TreeNode node2 = list.poll();
            if(node1 == null && node2 == null) continue;
            if(node1 == null || node2 == null || node1.val!=node2.val) return false;
            list.add(node1.left);
            list.add(node2.right);
            list.add(node1.right);
            list.add(node2.left);
        }
        return true;
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
