package com.hln.algorith.treenode;

public class _树的最大深度 {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public int maxDepth(TreeNode root){
       while (root!=null){
           int left = maxDepth(root.left);
           int right = maxDepth(root.right);
           return left > right ? left + 1 : right + 1;
       }
       return 0;
    }
}
