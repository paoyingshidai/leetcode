package com.michael.leetcode.offer;

/**
 * 剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 * @author Michael
 */
public class MirrorTree {

    /**
     * 中右左
     */
    public TreeNode mirrorTree(TreeNode root) {

        if (root == null) {
            return root;
        }

        TreeNode tempLeft = mirrorTree(root.left);
        TreeNode tempRight = mirrorTree(root.right);

        root.left = tempRight;
        root.right = tempLeft;

        return root;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
