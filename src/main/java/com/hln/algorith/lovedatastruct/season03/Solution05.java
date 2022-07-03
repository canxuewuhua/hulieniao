package com.hln.algorith.lovedatastruct.season03;

import com.hln.common.TreeNode;

/**
 * 二叉树的最近公共祖先
 */
public class Solution05 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
    }

    /**
     * 比如说 p为6 q为4 那他们的最近公共祖先为5 此时就可以缩小看问题 5为root 那么 6和4 其实就是在根节点5的两侧
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p , q);
        TreeNode right = lowestCommonAncestor(root.right, p ,q);
        if (left!=null && right!=null) return root;
        return (left!=null) ? left : right;
    }
}
