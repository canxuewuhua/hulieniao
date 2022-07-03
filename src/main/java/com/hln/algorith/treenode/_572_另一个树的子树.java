package com.hln.algorith.treenode;

import com.hln.common.TreeNode;

public class _572_另一个树的子树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(5);
        root.right = new TreeNode(4);
        postSerialize(root);
    }
    public boolean isSubTree(TreeNode s, TreeNode t){
        if (s == null || t == null) return false;
        return false;
    }

    private static String postSerialize(TreeNode node){
        StringBuilder sb = new StringBuilder();
        postSerialize(node, sb);
        return sb.toString();
    }

    /**
     * 后序遍历
     * @param node
     */
    private static void postSerialize(TreeNode node, StringBuilder sb){
        if (node.left == null){
            sb.append("#!");
        }else{
            postSerialize(node.left, sb);
        }
        if (node.right == null){
            sb.append("#!");
        }else{
            postSerialize(node.right, sb);
        }
        sb.append(node.val).append("!");
    }
}
