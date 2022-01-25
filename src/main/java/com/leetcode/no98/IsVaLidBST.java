package com.leetcode.no98;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/6
 * @description: 判断是否为正确的二叉搜索树
 */
public class IsVaLidBST {
    public boolean isValidBST(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if(curNode.left!=null){
                    queue.add(curNode.left);
                    if(curNode.val<=curNode.left.val) return false;
                }
                if(curNode.right!=null){
                    queue.add(curNode.right);
                    if(curNode.val>=curNode.right.val) return false;
                }
            }

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

