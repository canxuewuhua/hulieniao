package com.hln.algorith.treenode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class _从上到下打印二叉树 {

    public int[] levelOrder(TreeNode root) {
        // 步骤 1、将root节点放到一个Queue中 2、在弹出节点的时候 判断它的左右节点 然后将左右节点再放到queue 接着使用queue的poll方法
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);
        treeNode.right.right = treeNode3;
        treeNode.right.left = treeNode4;

        // new LinkedList<>();
        Queue<TreeNode> queue = new SynchronousQueue<>();
        if (treeNode != null){
            queue.add(treeNode);
        }
        System.out.println("将树形节点放到Queue中");

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        System.out.println("");

    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}
