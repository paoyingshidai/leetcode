package com.michael.leetcode.group1;

/**
 * 100.相同的树
 */
public class IsSameTree {


    public boolean isSameTree(TreeNode p, TreeNode q) {

        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        } else if ((p == null && q == null)) {
            return true;
        }

        if (!isSameTree(p.left, q.left)) {
            return false;
        }

        if (!isSameTree(p.right, q.right)) {
            return false;
        }

        return p.val == q.val;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode11 = new TreeNode(2);
        TreeNode treeNode12 = new TreeNode(3);

        treeNode1.left = treeNode11;
        treeNode1.right = treeNode12;


        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode21 = new TreeNode(2);
        TreeNode treeNode22 = new TreeNode(2);

        treeNode2.left = treeNode21;
//        treeNode2.right = treeNode22;


        IsSameTree isSameTree = new IsSameTree();

        boolean result = isSameTree.isSameTree(treeNode1, treeNode2);

        System.out.println(result);

    }

}

