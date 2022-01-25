package com.leetcode.no103;

import java.util.*;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/23
 * @description:
 */
public class SecondSolution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int count = 1;
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i <size ; i++) {
                TreeNode cur = queue.poll();
                level.add(cur.val);
                if(cur.left !=null){
                    queue.add(cur.left);
                }
                if(cur.right !=null){
                    queue.add(cur.right);
                }
            }
            count++;
            if(count % 2 == 0){
                Collections.reverse(level);
            }
            res.add(level);
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

