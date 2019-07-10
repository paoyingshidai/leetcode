package com.michael.leetcode.group5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *  
 *
 *
 *
 *  
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 *  
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Preorder {

    List<Integer> result = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) return result;
        recurrence(root, result);
        return result;
    }


    public void recurrence(Node root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        for (Node child : root.children) {
            recurrence(child, list);
        }
    }


    public void iterator(Node root, List<Integer> list) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        do {
            Node node = stack.pop();
            list.add(node.val);

            List<Node> nodeList = node.children;

            for (int i = nodeList.size() - 1; i >= 0; i--) {
                stack.push(nodeList.get(i));
            }

//            for (Node child : node.children) {
//                stack.push(child);
//            }
        } while (!stack.isEmpty());
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
