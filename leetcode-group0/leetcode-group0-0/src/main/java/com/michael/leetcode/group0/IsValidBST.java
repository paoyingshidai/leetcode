package com.michael.leetcode.group0;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValidBST {

    TreeNode pre = null;

    /**
     * 左边的任何一个节点的值都比右边任何一个只要小 即：left(max) < right(min)
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;               // 这个递归会一直追寻到某个节点的最左边的叶子节点
        if (pre != null && pre.val >= root.val) return false;   // 左边的作为 pre, 与根节点进行比较，
        pre = root;                                             // 然后将根节点作为 pre,
        return isValidBST(root.right);                          // 与右边的节点进行比较。
    }





    public static void main(String[] args) {
        TreeNode root0 = new TreeNode(10);
        TreeNode root1 = new TreeNode(5);
        TreeNode root2 = new TreeNode(15);
//        TreeNode root3 = new TreeNode(3);
//        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(6);
        TreeNode root6 = new TreeNode(20);

        root2.left = root5;
        root2.right = root6;

//        root1.left = root3;
//        root1.right = root4;

        root0.left = root1;
        root0.right = root2;


        TreeNode root12 = new TreeNode(2);
        TreeNode root11 = new TreeNode(1);
        TreeNode root13 = new TreeNode(3);
        root12.left = root11;
        root12.right = root13;


        IsValidBST isValidBST = new IsValidBST();
        boolean result = isValidBST.isValidBST(root0);
        System.out.println(result);

//        System.out.println(isValidBST.isValidBST(null));

    }


    public boolean isValidate(TreeNode root) {
        if (root == null) return true;
        if (!isValidate(root.left)) return false;
        if (pre != null && pre.val >= root.val) return false;
        pre = root;
        return isValidate(root.right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
