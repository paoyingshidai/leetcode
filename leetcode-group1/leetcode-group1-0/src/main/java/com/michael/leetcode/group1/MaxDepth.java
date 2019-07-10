package com.michael.leetcode.group1;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class MaxDepth {

    private int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        recurrence(root, 1);
        return maxDepth;
    }

    public void recurrence(TreeNode root, int level) {
        if (root == null) {
            maxDepth = Math.max(maxDepth, level - 1);
            return;
        }
        recurrence(root.left, level + 1);
        recurrence(root.right, level + 1);
    }


    /**
     * 官方解题
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    public static void main(String[] args) {
        TreeNode root0 = new TreeNode(0);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        TreeNode root7 = new TreeNode(7);

        root2.left = root5;
        root2.right = root6;

        root6.right = root7;

        root1.left = root3;
        root1.right = root4;

        root0.left = root1;
        root0.right = root2;


        MaxDepth depth = new MaxDepth();
        System.out.println(depth.maxDepth(root7));

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
