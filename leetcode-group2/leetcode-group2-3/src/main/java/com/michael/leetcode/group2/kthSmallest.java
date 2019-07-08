package com.michael.leetcode.group2;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class kthSmallest {

    /**
     *  这个遍历二叉搜索树的方法，（非递归）
     *
     * 官方：
     * 二叉搜索树BST有一个重要性质：中序遍历为排序数组，根据这个性质，我们可将问题转化为寻找中序遍历第k个节点的值；
     * 实现的方法是建立两个全局变量res和count，分别用于存储答案与计数：
     * 在每次访问节点时，计数器-1；
     * 当count == 0时，代表已经到达第k个节点，此时记录答案至res；
     * 找到答案后，已经不用继续遍历，因此每次判断res是否为空，若不为空直接返回。
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> tree_stack = new Stack<>();
        int tempIndex = 0;

        while (root != null) {
            tree_stack.push(root);
            root = root.left;
        }

        while(!tree_stack.isEmpty()) {
            TreeNode cur = tree_stack.pop();

            tempIndex++;
            if (tempIndex == k) return cur.val;

            if (cur.right != null) {
                TreeNode node = cur.right;
                do {
                    tree_stack.push(node);
                } while ((node = node.left) != null);
            }
        }
        return 0;
    }


    /**
     *
     * 递归，执行时间更快，占用空间更小，因为没有出栈入栈，与栈空间的开销
     *
     */
    private int res = Integer.MAX_VALUE, count;
    public int kthSmallest1(TreeNode root, int k) {
        count = k;
        inorder(root);
        return res;
    }
    private void inorder(TreeNode root) {
        if(root != null) {
            inorder(root.left);
            if(res != Integer.MAX_VALUE) return;
            if(--count == 0) res = root.val;
            inorder(root.right);
        }
    }



    // [3, 1, 4, 0, 5, 2, 6]
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

        kthSmallest kthSmallest = new kthSmallest();
        System.out.println(kthSmallest.kthSmallest(root0, 7));

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
