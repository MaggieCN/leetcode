package com.leetcode.no701;

//https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/solution/2-de-cha-ru-by-sweetiee/
public class RightAnswer {
    /**
     *迭代解法
     * 如果 root 是空，则新建树节点作为根节点返回即可。
     * 否则：
     * 初始化 cur 指向 root。
     * 比较 cur.val 与目标值的大小关系：
     * 如果 cur.val 大于目标值，说明目标值应当插入 cur 的左子树中，
     * 如果 cur.left 为 null，表明这是目标值可以插入的位置，直接插入并返回即可；否则 cur 指向 cur.left，重复步骤 2；
     * 如果 cur.val 小于目标值，说明目标值应当插入 cur 的右子树中。
     * 如果 cur.right 为 null，表明这是目标值可以插入的位置，直接插入并返回即可；否则 cur 指向 cur.right，重复步骤 2。
     *
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) {
            return node;
        }

        TreeNode cur = root;
        while (true) {
            if (cur.val > val) {
                if (cur.left == null) {
                    cur.left = node;
                    break;
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = node;
                    break;
                }
                cur = cur.right;
            }
        }
        return root;
    }

    /**
     *如果 root 是空，则新建树节点作为根节点返回即可。
     * 否则比较 root.val 与目标值的大小关系：
     * 如果 root.val 大于目标值，说明目标值应当插入 root 的左子树中，问题变为了在 root.left 中插入目标值，递归调用当前函数；
     * 如果 root.val 小于目标值，说明目标值应当插入 root 的右子树中，问题变为了在 root.right 中插入目标值，递归调用当前函数。
     *
     */
    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
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



