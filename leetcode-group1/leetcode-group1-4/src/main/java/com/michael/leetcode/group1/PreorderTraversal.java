package com.michael.leetcode.group1;

import lombok.val;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 */
public class PreorderTraversal {

    List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        doTraversal(root);
        return result;
    }

    public void doTraversal(TreeNode node) {

        if (node == null) {
            return;
        }
        result.add(node.val);
        doTraversal(node.left);
        doTraversal(node.right);
    }

    /**
     * 非递归前序遍历
     *
     * @param root
     * @param result
     */
    public void traversal2Iterator(TreeNode root, List<Integer> result) {

        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {

            TreeNode node = s.pop();
            result.add(node.val);

            if (node.right != null) {
                s.push(node.right);
            }

            if (node.left != null) {
                s.push(node.left);
            }
        }
    }

}



 class TreeNode {
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
