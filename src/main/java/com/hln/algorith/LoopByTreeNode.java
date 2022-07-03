package com.hln.algorith;

import com.hln.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树 前序 中序 后序 层序
 * 二叉树前中后序的递归版本属于easy题，而迭代版本通常是medium甚至是hard
 * 二分查找
 * 可参考网址：https://www.cnblogs.com/zhi-leaf/p/10813048.html 提供递归和非递归方式
 *
 * 预备知识点 Java队列的poll,peek,element的区别
 * poll：将首个元素从队列中弹出，如果队列是空的，就返回null
 * peek：查看首个元素，不会移除首个元素，如果队列是空的就返回null
 * element：查看首个元素，不会移除首个元素，如果队列是空的就抛出异常NoSuchElementException
 * poll,peek,element的共同点：都是返回队列中的首个元素
 *
 * 另外 add() offer()
 * 区别：两者都是往队列尾部插入元素，不同的时候，当超出队列界限的时候，add（）方法是抛出异常让你处理，而offer（）方法是直接返回false
 * remove() : 移除队列头的元素并且返回，如果队列为空则抛出异常
 * poll() : 移除队列头的元素并且返回，如果队列为空则返回null
 */
public class LoopByTreeNode {

    /**
     * 前序遍历：4 2 1 3 6 5 7 8 10
     * 中序遍历：1 2 3 4 5 6 7 8 10
     * 后序遍历：1 3 2 5 10 8 7 6 4
     * 层序遍历：4 2 6 1 3 5 7 8 10
     */

    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
        TreeNode root = new TreeNode(2);
        // 前序
        preorder(root, res);
    }

    /**
     * 前序遍历 递归
     */
    public static void preorder(TreeNode root, List<Integer> res) {
        if (root == null){
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    /**
     * 中序遍历 递归
     */
    public static void inOrder(TreeNode root, List<Integer> res) {
        if (root == null){
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }

    /**
     * 后序遍历 递归
     */
    public static void postOrder(TreeNode root, List<Integer> res) {
        if (root == null){
            return;
        }
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.val);
    }

    /**
     * 后序遍历 递归
     */
    public static void levelOrder(TreeNode root, List<Integer> res){
        if (root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
    }
}
