package com.michael.leetcode.group1;

import java.util.Stack;

/**
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 *
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 *
 * 示例：
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 *  
 *
 * 提示：
 *
 * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search-tree-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BSTIterator {

    Stack<TreeNode> tree_stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        while(root != null){
            tree_stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tn = tree_stack.pop();
        if(tn.right == null) {
            return tn.val;
        } else {
            TreeNode cu = tn.right;
            do {
                tree_stack.push(cu);
            } while((cu=cu.left) != null);
            return tn.val;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !tree_stack.isEmpty();
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

        BSTIterator iterator = new BSTIterator(root0);

        while(iterator.hasNext()) {
            int next = iterator.next();
            System.out.println(next);
        }


    }





    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
