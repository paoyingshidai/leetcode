package com.michael.leetcode.group1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LevelOrder {

    private List<List<Integer>> result = new ArrayList<>();

    /**
     * 广度优先，效率比较低
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) return Collections.emptyList();

        result.add(Stream.of(root.val).collect(Collectors.toList()));

        Queue<TreeNode> queue = new ArrayDeque();
        if (root.left != null)
            queue.offer(root.left);
        if (root.right != null)
            queue.offer(root.right);

        recurrence(queue);
        return result;
    }


    public void recurrence(Queue<TreeNode> queue) {
        if (queue == null || queue.isEmpty()) return;

        TreeNode node = null;
        Queue<TreeNode> queueTemp = new ArrayDeque();
        List<Integer> temp = null;

        while(!queue.isEmpty()) {
            node = queue.poll();
            if (temp == null) temp = new ArrayList<>();
            temp.add(node.val);
            if (node.left != null)
                queueTemp.offer(node.left);
            if (node.right != null)
                queueTemp.offer(node.right);
        }
        result.add(temp);
        recurrence(queueTemp);
    }

    // ------------------------------------------------------------------
//
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/er-cha-shu-de-ceng-ci-bian-li-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    /**
     * 深度优先
     */
    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

        // fulfil the current level
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }


    /**
     * 深度优先非递归算法
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        while ( !queue.isEmpty() ) {
            // start the current level
            levels.add(new ArrayList<Integer>());

            // number of elements in the current level
            int level_length = queue.size();
            for(int i = 0; i < level_length; ++i) {
                TreeNode node = queue.remove();

                // fulfill the current level
                levels.get(level).add(node.val);

                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            // go to next level
            level++;
        }
        return levels;
    }








    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
