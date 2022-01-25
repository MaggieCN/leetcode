package com.leetcode.no113;

import java.util.*;

/**
 * @author: gaomeiqi
 * @Date: 2022/1/2
 * @description:
 * https://leetcode-cn.com/problems/path-sum-ii/solution/hui-su-suan-fa-shen-du-you-xian-bian-li-zhuang-tai/
 *
 */
public class RightAnswer {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // Java 文档中 Stack 类建议使用 Deque 代替 Stack，注意：只使用栈的相关接口
        Deque<Integer> path = new ArrayDeque<>();
        dfs(root, sum, path, res);
        return res;
    }

    private void dfs(TreeNode node, int sum, Deque<Integer> path, List<List<Integer>> res) {
        // 递归终止条件 1
        if (node == null) {
            return;
        }

        // 递归终止条件 2
        if (node.val == sum && node.left == null && node.right == null) {
            // 当前结点的值还没添加到列表中，所以要先添加，然后再移除
            path.addLast(node.val);
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }

        path.addLast(node.val);
        dfs(node.left, sum - node.val, path, res);
        // 进入左右分支的 path 是一样的，这里不用写下面两行，因为一定会调用到 path.removeLast();
        // path.removeLast();
        // path.addLast(node.val);
        dfs(node.right, sum - node.val, path, res);
        path.removeLast();
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


