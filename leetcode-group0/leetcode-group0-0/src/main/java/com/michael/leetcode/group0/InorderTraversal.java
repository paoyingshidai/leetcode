package com.michael.leetcode.group0;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InorderTraversal {


    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        traversal1Iterator(root, result);
//        traversal1(root, result);

        return result;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        traversal2(root, result);

        return result;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();

//        traversal3(root, result);
        traversal3Iterator(root, result);

        return result;
    }


    /**
     * 递归中序遍历
     *
     * @param root
     * @param result
     */
    public void traversal1(TreeNode root, List<Integer> result) {

        if (root.left != null) {
            traversal1(root.left, result);
        }

        result.add(root.val);

        if (root.right != null) {
            traversal1(root.right, result);
        }
    }

    /**
     * 迭代中序遍历
     *
     * @param root
     * @param result
     */
    public void traversal1Iterator(TreeNode root, List<Integer> result) {

        Stack <TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // 把 root 的所有左节点入站
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }

//        do {
//            while (root != null) {
//                s.push(root);
//                root = root.left;
//            }
//            if (!s.isEmpty()) {
//                TreeNode node = s.pop();
//                result.add(node.val);
//                root = node.right;
//            }
//        } while (!s.isEmpty() || root != null);
    }

    /**
     * 递归前序遍历
     *
     * @param root
     * @param result
     */
    public void traversal2(TreeNode root, List<Integer> result) {

        result.add(root.val);
        if (root.left != null) {
            traversal2(root.left, result);
        }

        if (root.right != null) {
            traversal2(root.right, result);
        }
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
            result.add(0, node.val);          // 这个设计很微妙，先将左节点入栈，然后右节点入栈，取出中节点，
            // 然后下一个循环时，取出右节点，再左节点。这样顺序是 中->右->左，
            // 但是在队列添加的时候将顺序调换，就使得顺序正确 左->右->中。
        }
    }


    public static void main(String[] args) {

        TreeNode root0 = new TreeNode(0);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);

        root2.left = root5;
        root2.right = root6;

        root1.left = root3;
        root1.right = root4;

        root0.left = root1;
        root0.right = root2;

        InorderTraversal traversal = new InorderTraversal();
        List<Integer> result = traversal.inorderTraversal(root0);
        List<Integer> result2 = traversal.inorderTraversal2(root0);
        List<Integer> result3 = traversal.inorderTraversal3(root0);

        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);

    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

