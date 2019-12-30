package com.michael.leetcode.group9;

/**
 * 965. 单值二叉树
 */
public class IsUnivalTree {

    public boolean isUnivalTree(TreeNode root) {

        boolean left = (root.left == null ||
                (root.val == root.left.val && isUnivalTree(root.left)));

        boolean right = (root.right == null ||
                (root.val == root.right.val && isUnivalTree(root.right)));

        return left && right;

//        作者：LeetCode
//        链接：https://leetcode-cn.com/problems/univalued-binary-tree/solution/dan-zhi-er-cha-shu-by-leetcode/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
