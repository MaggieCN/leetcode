package com.leetcode.no34;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author MaggieCN
 * @Date 2021/10/28
 * @Description
 * 当5，4，11，7 的时候，由于最后不满足条件但也是最后的叶子节点，所以要返回到上一个根节点
 * 然后再遍历上一个根节点的右子树
 * 当左右TreeNode都为null, 并且 剩下的值等于root.val 那么就把list加入到result中
 */
public class RightAnswer {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(new ArrayList<>(),root,target, result);
        return result;
    }
    public void dfs(List<Integer> list, TreeNode root, int sum, List<List<Integer>> result){
        if (root == null) return;
        list.add(new Integer(root.val));
        if (root.left == null && root.right == null){
            if(sum == root.val){
                //result.add(new ArrayList(list));
                //list是引用传递，所以在加入到result 的时候，list在之后会动态变化，
                //相应的也会影响到加入到result 中的list ，到最后，list会变成空，result加入的所有list 都会受到影响，变为空，
                //为避免这种情况，要把list复制到一个新建的list中去，这样才行
                result.add(list);
            }
            list.remove(list.size()-1);
            return;
        }
        dfs(list,root.left,sum-root.val, result);
        dfs(list,root.right,sum-root.val, result);
        //不满足条件的最后一个加入，删除
        list.remove(list.size()-1);
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
