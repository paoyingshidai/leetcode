package com.michael.leetcode.group4;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 *
 * 示例:
 *
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 *
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 *
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 *
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteNode {

    public TreeNode deleteNode(TreeNode root, int key) {

        TreeNode parent = root;
        TreeNode node = root; // 记录找到的节点
        while (node != null) {
            if (key == node.val) { // 找到了
                break;
            }
            parent = node;
            node = key > node.val ? node.right : node.left;
        }
        if (node == null) { // 没找到删除的值
            return root;
        }

        if (node.left == null && node.right == null) { // 找到的是叶节点
            if (node == root) { // 只有一个根节点的情况
                return null;
            }
            if (parent.left == node) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (node.left != null && node.right == null) { // 只有左子树的情况
            if (node == root) { // 根节点特殊处理
                return node.left;
            }
            if (parent.left == node) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
            node.left = null;
        } else if (node.left == null && node.right != null) { // 只有右子树的情况
            if (node == root) { // 根节点特殊处理
                return node.right;
            }
            if (parent.left == node) {
                parent.left = node.right;
            } else {
                parent.right = node.right;
            }
            node.right = null;
        } else { // 左右子树的情况，找右子树中最小的节点替换即可
            TreeNode target = node;
            parent = node;
            node = node.right;
            while (node.left != null) { // 看看是否有左子树
                parent = node;
                node = node.left;
            }
            target.val = node.val;
            if (parent.left == node) {
                parent.left = node.right;
            } else {
                parent.right = node.right;
            }
            node.right = null;
        }
        return root;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
