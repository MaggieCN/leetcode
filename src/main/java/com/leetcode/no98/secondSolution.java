package com.leetcode.no98;

/**
 * @author: gaomeiqi
 * @Date: 2022/1/5
 * @description:
 */
public class secondSolution {
    //使用long为了满足在最左节点是INT_MIN的时候，也不会判断为false
    private long pre = Long.MIN_VALUE;
    public boolean isValidBST(IsVaLidBST.TreeNode root) {
        if(root == null) return true;
        if(!isValidBST(root.left)) return false;
        if(root.val <= pre) return false;
        pre = root.val;
        return isValidBST(root.right);
    }
}
