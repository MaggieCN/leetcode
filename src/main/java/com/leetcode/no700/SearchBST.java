package com.leetcode.no700;

import java.util.ArrayDeque;
import java.util.Queue;

public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if(curNode.val == val) return curNode;
                if(curNode.left!=null) queue.add(curNode.left);
                if(curNode.right!=null) queue.add(curNode.right);
            }
        }
        return null;
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


