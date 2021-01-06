package com.michael.leetcode.group1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PostorderTraversal {

    List<Integer> result = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        recurrence(root);
        return result;
    }
    /**
     * 递归后序遍历
     *
     * @param root
     * @param result
     */
    public void traversal3(TreeNode root, List<Integer> result) {

        if (root.left != null) {
            traversal3(root.left, result);
        }

        if (root.right != null) {
            traversal3(root.right, result);
        }

        result.add(root.val);
    }

    /**
     * 递归后序遍历
     *
     * @param root
     * @param result
     */
    public void traversal3Iterator(TreeNode root, List<Integer> result) {

        if (root == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            if (node.left != null) {
                s.push(node.left);
            }

            if (node.right != null) {
                s.push(node.right);
            }
            result.add(0, node.val);
            // 这个设计很微妙，先将左节点入栈，然后右节点入栈，取出中节点，
            // 然后下一个循环时，取出右节点，再左节点。这样顺序是 中->右->左，
            // 但是在队列添加的时候将顺序调换，就使得顺序正确 左->右->中。
        }
    }
    /**
     * 递归
     * @param root
     */
    public void recurrence(TreeNode root) {
        if (root == null) return;
        recurrence(root.left);
        recurrence(root.right);
        result.add(root.val);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


}
