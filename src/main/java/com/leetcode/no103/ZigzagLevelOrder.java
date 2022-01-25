package com.leetcode.no103;

import java.util.*;
/**
 * @Author MaggieCN
 * @Date 2021/11/23
 * @Description
 * change 这一变量，判断奇数行偶数行
 */

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res =  new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int change = 0;
        while (!queue.isEmpty()){
            int num = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i <num ; i++) {
                TreeNode curNode = queue.poll();
                /** 利用LinkedList 链表的结构，可以在链表的头节点或者尾节点添加
                if(change%2 == 0){
                    level.addLast(curNode.val);
                }else{
                    level.addFirst(curNode.val);
                }
                 */
                if(curNode.left !=null){
                    queue.add(curNode.left);
                }
                if(curNode.right !=null){
                    queue.add(curNode.right);
                }
            }
            //利用集合reverse 可以将数组取反
            if(change%2 == 1){
                Collections.reverse(level);
            }
            res.add(level);
            change++;
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
