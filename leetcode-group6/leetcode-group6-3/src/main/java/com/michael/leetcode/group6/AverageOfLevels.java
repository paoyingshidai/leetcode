package com.michael.leetcode.group6;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 *
 * 示例 1:
 *
 * 输入:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 * 注意：
 *
 * 节点值的范围在32位有符号整数范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AverageOfLevels {

//    private List<List<Integer>> result = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();

        if (root == null) return Collections.emptyList();

        // 第一级
        result.add((double)root.val);

        Queue<TreeNode> queue = new ArrayDeque();
        if (root.left != null)
            queue.offer(root.left);
        if (root.right != null)
            queue.offer(root.right);

        recurrence(queue, result);

        return result;
    }


    public void recurrence(Queue<TreeNode> queue, List<Double> result) {
        if (queue == null || queue.isEmpty()) return;

        TreeNode node = null;
        Queue<TreeNode> queueTemp = new ArrayDeque();
        double temp = 0.0;
        int count = queue.size();
        while(!queue.isEmpty()) {
            node = queue.poll();
            temp += node.val;

            if (node.left != null)
                queueTemp.offer(node.left);
            if (node.right != null)
                queueTemp.offer(node.right);
        }
        result.add(temp / count);
        recurrence(queueTemp, result);
    }




    List<List<Integer>> levels = new ArrayList<>();
    public void helper(TreeNode node, int level) {
        if (levels.size() == level)
            levels.add(new ArrayList<>());

        levels.get(level).add(node.val);

        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }

    public List<Double> levelOrder2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        helper(root, 0);

        return levels.stream().mapToDouble(
                item -> item.stream().mapToDouble(i -> i.doubleValue()).average().getAsDouble())
                .boxed().collect(Collectors.toList());
    }










    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
