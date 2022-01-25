package com.leetcode.no101;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class TreeIsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> levelList = new LinkedList<>();
            if(size!=Math.pow(2,level)) return false;
            for (int i = 0; i <size ; i++) {
                TreeNode curNode = queue.poll();
                if(i > size/2 && size!=1){
                    if(curNode.val == levelList.removeLast()) continue;
                    else return false;
                }else{
                    levelList.addLast(curNode.val);
                }
                if(curNode.left!=null) queue.add(curNode.left);
                if(curNode.right!=null) queue.add(curNode.right);
            }
            level++;
        }
        return true;
    }

    public boolean isSymmetric1(TreeNode root) {
        if(root == null) return true;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root.left);
        list.add(root.right);
        while (!list.isEmpty()){

        }
        return true;
    }

    public static void test(){
        LinkedList<Integer> levelList = new LinkedList<>();
        levelList.addLast(3);
        levelList.addLast(4);
        System.out.println(levelList.removeLast());
        System.out.println(levelList.removeLast());
        for (int i = 0; i <4 ; i++) {
            if(i > 2/2){
                if(i > 2/2) continue;
                else System.out.println("hd"+i);
            }else{
                System.out.println("小于"+i);
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        test();
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




