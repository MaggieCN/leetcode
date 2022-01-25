package testAnnual.Solution20211113;

import java.util.ArrayList;
import java.util.List;

public class SolutionTree {
    //给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
    //输入：root = [1,null,2,3]
    //输出：[1,2,3]
    // 如果根节点不为空，加入这个值， 循环遍历left, 如果left 不为空，加入val 小循环也是左右，大循环也是左右
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        dfs(root,list);
        return list;
    }
    public void dfs(TreeNode root, List<Integer> list){
        while(root!=null){
            list.add(root.val);
            if(root.left!=null){
                dfs(root.left,list);
            }
            if(root.right!=null){
                dfs(root.left,list);
            }
        }
    }
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfsTreeNode(root, result);
        return result;
    }
    public void dfsTreeNode(TreeNode root, List<Integer> result){
        if(root!=null){
            result.add(root.val);
            if(root.left!=null){
                dfsTreeNode(root.left, result);
            }
            if(root.right!=null) {
                dfsTreeNode(root.right, result);
            }
        }
    }
    //输入：root = [1,null,2,3]
    //输出：[1,3,2]
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfsMidTree(root,list);
        return list;
    }
    public void dfsMidTree(TreeNode root, List<Integer> list){
        if(root.left!=null){
            dfsMidTree(root.left,list);
        }
        list.add(root.val);
        if(root.right!=null){
            dfsMidTree(root.right,list);
        }
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


