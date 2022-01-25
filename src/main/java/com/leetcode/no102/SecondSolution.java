package com.leetcode.no102;

import java.util.*;

/**
 * @Author MaggieCN
 * @Date 2021/11/19
 * @Description
 */
public class SecondSolution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        /* 三种判断queue 是否为空的方式
            queue.isEmpty(), 为空返回true，不为空返回false。
            queue.peek(), 为空返回null，不为空返回栈顶元素。
            queue.size(), 为空返回0，不为空返回一个大于1的整数。
        */
        while(!queue.isEmpty()){
            int num = queue.size();
            //由于本题是返回一个二维数组，所以附加一个List<Integer> level 用于存储每层的数组。
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i <num ; i++) {
                //poll() : 移除队列头的元素并且返回，如果队列为空则返回null
                TreeNode curNode = queue.poll();
                level.add(curNode.val);
                //移除原有的queue后，如果还存在left ,right 则继续添加。
                //注意这里是往queue中添加，但由于之前已经设定好num该层遍历的次数，所以新添加的会在这一层结束后，才会新遍历。
                if (curNode.left != null){
                    queue.add(curNode.left);
                }
                if (curNode.right != null){
                    queue.add(curNode.right);
                }
            }
            res.add(level);
        }
        return res;
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
