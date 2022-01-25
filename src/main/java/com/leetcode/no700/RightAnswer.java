package com.leetcode.no700;

//二叉搜索樹
//二叉搜索树（Binary Search Tree）是具有二叉树结构，每个节点都有一个可比较的Key , 并且对于任何一个节点而言，它的左边的所有节点的Key都比它的Key小，右边所有节点的Key都比它的Key大。(以下简称BST)
public class RightAnswer {
    public TreeNode searchBST(TreeNode root, int val) {
        return dfs(root, val);
    }
    private TreeNode dfs(TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        if (node.val == val) {
            return node;
        }
        if (node.val > val) {
            return dfs(node.left, val);
        }
        return dfs(node.right, val);
    }

    public TreeNode searchBST1(TreeNode root, int val) {
        TreeNode curNode = root;
        while(curNode!=null){
            if(curNode.val == val) return curNode;
            if(curNode.val > val) curNode = curNode.left;
            else curNode = curNode.right;
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




