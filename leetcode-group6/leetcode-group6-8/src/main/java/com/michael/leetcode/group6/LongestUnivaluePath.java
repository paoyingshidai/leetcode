package com.michael.leetcode.group6;


public class LongestUnivaluePath {


    private int max;

    /**
     * 1.About Complexity
     * 1.1 Time Complexity is O(n)
     * 1.2 Space Complexity is O(n)
     * 2.how I solve
     * 2.1 this solution is base on depth traversal
     * 2.2 static left and right children tree's depth,and at the same time judge current node's val is same as parent's val
     * 3.About submit record
     * 3.1 9ms and 51.8MB memory in LeetCode China
     * 3.2 3ms and 40.5MB memory in LeetCode
     * 4.Q&A
     *
     * @param root
     * @return
     */
    public int longestUnivaluePath(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        postOrder(root, root.val);
        return max;
    }

    private int postOrder(BinaryTreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        int left = postOrder(root.left, root.val);
        int right = postOrder(root.right, root.val);
        max = Math.max(max, left + right);
        if (root.val == val) {
            return Math.max(left, right) + 1;
        }
        return 0;
    }

//    作者：cartoon
//    链接：https://leetcode-cn.com/problems/longest-univalue-path/solution/shen-du-bian-li-qiu-jie-by-cartoon-3/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


}

class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int x) {
        val = x;
    }
}
