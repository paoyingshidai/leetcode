package com.michael.leetcode.group7;

/**
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 *
 * 例如, 
 *
 * 给定二叉搜索树:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和 插入的值: 5
 * 你可以返回这个二叉搜索树:
 *
 *          4
 *        /   \
 *       2     7
 *      / \   /
 *     1   3 5
 * 或者这个树也是有效的:
 *
 *          5
 *        /   \
 *       2     7
 *      / \
 *     1   3
 *          \
 *           4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-into-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InsertIntoBST {


    /**
     * 官方：思想是根据根节点进行判断，如果小于根节点就插入左边，否则插入右边，
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        //根据BST的性质找到需要插入的点
        if(root.val > val){
            root.left =  insertIntoBST(root.left,val);
        }else{
            root.right = insertIntoBST(root.right,val);
        }
        return root;
    }

    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        TreeNode node = searchBST(root, val);

        // 如果都没有，即 val 最大
        if (node == null) {
            TreeNode rightNode = rightNode(root);
            rightNode.left = new TreeNode(val);
        } else {
            if (node.left == null) {
                node.left = new TreeNode(val);
            } else {    // 左子树的最大节点
                TreeNode rightNode = rightNode(node.left);
                rightNode.left = new TreeNode(val);
            }
        }
        return root;
    }

    /**
     * 查找第一个大于 val 的节点
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val > val) return root;

        TreeNode leftNode = searchBST(root.left, val);
        return leftNode == null ? searchBST(root.right, val) : leftNode;
    }

    /**
     * 获取数的最大节点，即最右边的节点
     * @param root
     * @return
     */
    public TreeNode rightNode(TreeNode root) {
        if (root.right == null) {
            return root;
        }
        return rightNode(root.right);
    }



    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
