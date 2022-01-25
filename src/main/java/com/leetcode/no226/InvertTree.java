package com.leetcode.no226;

import java.util.LinkedList;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        TreeNode res = root;
        res.left = root.right;
        res.right = root.left;
        LinkedList<TreeNode> listRoot = new LinkedList<>();
        LinkedList<TreeNode> listCur = new LinkedList<>();
        listRoot.add(root.right);
        listRoot.add(root.left);
        listCur.add(res.left);
        listCur.add(res.right);
        while (!listRoot.isEmpty()){
            TreeNode left = listRoot.pop();
            TreeNode right = listRoot.pop();
            TreeNode curRight = listCur.pop();
            TreeNode curLeft = listCur.pop();
            if(left!=null){
                curRight.right = left.left;
                curRight.left = left.right;
            }
            if(right!=null){
                curLeft.left = right.right;
                curLeft.right = right.left;
            }
            listRoot.add(right.right);
            listRoot.add(right.left);
            listRoot.add(left.right);
            listRoot.add(left.left);
            listCur.add(left.left);
            listCur.add(left.right);
            listCur.add(right.left);
            listCur.add(right.right);
        }
        return res;
    }

    public TreeNode invertTree1(TreeNode root) {
        if(root == null) return root;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()){
            TreeNode tmp = list.poll();
            TreeNode left = tmp.left;
            tmp.left = tmp.right;
            tmp.right = left;
            if(tmp.left!=null){
                list.add(tmp.left);
            }
            if(tmp.right!=null){
                list.add(tmp.right);
            }
        }
        return root;
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


