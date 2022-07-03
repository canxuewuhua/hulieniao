package com.hln.二叉树.打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class _从上到下打印二叉树 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left !=null) queue.add(node.left);
                if (node.right !=null) queue.add(node.right);
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        levelOrder(node1);
    }

}
