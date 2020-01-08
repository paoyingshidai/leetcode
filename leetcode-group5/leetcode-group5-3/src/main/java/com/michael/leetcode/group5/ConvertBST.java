package com.michael.leetcode.group5;

/**
 * 538. 把二叉搜索树转换为累加树
 */
public class ConvertBST {

    private int sum = 0;

    /**
     * 这道题的精彩的地方是，从有节点开始遍历
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;         // 这里先把值设置了，然后在加上左边的值，顺序不能变
            convertBST(root.left);
        }
        return root;
    }

    //    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree/solution/ba-er-cha-sou-suo-shu-zhuan-huan-wei-lei-jia-shu-3/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
