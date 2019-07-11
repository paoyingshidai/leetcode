package com.michael.leetcode.group1;

import java.util.ArrayList;
import java.util.List;

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




    public void iterator(TreeNode root) {






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
