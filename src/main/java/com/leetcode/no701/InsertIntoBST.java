package com.leetcode.no701;

public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode insertNode = new TreeNode(val);
        TreeNode res = root;
        TreeNode tmp = res;
        while (tmp!=null){
            if(tmp.val<val){
                if(tmp.right == null){
                    tmp.right = insertNode;
                    break;
                }else {
                    tmp = tmp.right;
                }
            }else{
                if(tmp.left == null){
                    tmp.left = insertNode;
                    break;
                }else {
                    tmp = tmp.left;
                }
            }
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


