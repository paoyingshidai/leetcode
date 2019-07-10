package com.michael.leetcode.group4;

import java.util.*;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个 3叉树 :
 *
 *  
 *
 *
 *
 *  
 *
 * 返回其层序遍历:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *  
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LevelOrder {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();

        List<Integer> value = new ArrayList<>();
        value.add(root.val);
        result.add(value);

        Queue<Node> queue = new ArrayDeque<>();
        List<Node> nodeList = root.children;
        for (Node node : nodeList) {
            queue.offer(node);
        }

        recurrence(queue);
        return result;
    }


    public void recurrence(Queue<Node> queue) {

        if (queue == null || queue.isEmpty()) return;

        Node node = null;
        List<Integer> temp = null;
        Queue<Node> queue_temp = null;

        while(!queue.isEmpty()) {
            node = queue.poll();
            if (temp == null) temp = new ArrayList<>();
            temp.add(node.val);

            List<Node> nodeList = node.children;
            for (Node node1 : nodeList) {
                if (queue_temp == null) queue_temp = new ArrayDeque<>();
                queue_temp.offer(node1);
            }
        }
        result.add(temp);
        recurrence(queue_temp);
    }


    public static void main(String[] args) {

    }


    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
