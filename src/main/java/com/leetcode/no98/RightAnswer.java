package com.leetcode.no98;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/6
 * @description:
 */
public class RightAnswer {
    //https://leetcode-cn.com/problems/validate-binary-search-tree/solution/zhong-xu-bian-li-qing-song-na-xia-bi-xu-miao-dong-/
    /**
     * 中序遍历
     */
    long pre = Long.MIN_VALUE;
    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST1(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST1(root.right);
    }
    //https://leetcode-cn.com/problems/validate-binary-search-tree/solution/die-dai-yu-di-gui-by-powcai/
    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        TreeNode pre = null;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (pre != null && pre.val >= p.val) return false;
            pre = p;
            p = p.right;
        }
        return true;
    }


    public boolean isValidBST3(TreeNode root) {
        TreeNode pre = null;
        if (root == null) return true;
        if (!isValidBST3(root.left)) return false;
        if (pre != null && pre.val >= root.val) return false;
        pre = root;
        return isValidBST3(root.right);
    }

    public boolean isValidBST4(TreeNode root) {
        return isBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean isBST(TreeNode root, long maxValue, long minValue) {
        if (root == null) return true;
        if (root.val >= maxValue || root.val <= minValue) return false;
        return isBST(root.left, root.val, minValue) && isBST(root.right,  maxValue, root.val);
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

