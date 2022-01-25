package com.leetcode.no102;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author MaggieCN
 * @Date 2021/11/19
 * @Description 层序遍历
 *
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        res.add(path);
        TreeNode left = root.left;
        TreeNode right = root.right;
        dfsLevel(res,new ArrayList<>(),left, right, 1);
        return res;
    }

    public void dfsLevel(List<List<Integer>> res,
                         List<Integer> path,
                         TreeNode left,
                         TreeNode right,
                         int level) {
        if(left == null && right == null){
            return;
        }
        for (int i = 1; i <level ; i++) {
            dfsLevel(res, path, left, right, level);
        }
        level ++;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}



