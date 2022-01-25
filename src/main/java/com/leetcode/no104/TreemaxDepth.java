package com.leetcode.no104;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreemaxDepth {
    public int maxDepth(TreeNode root) {
        int res = 0;
        if(root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode tmp = queue.poll();
                if(tmp.left!=null) queue.add(tmp.left);
                if(tmp.right!=null) queue.add(tmp.right);
            }
            res++;
        }
        return res;
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



