package com.michael.leetcode.group0;

/**
 * 92
 * 题目描述
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class ReverseBetween {

    /**
     * 反转链表
     * 链表
     * @param head
     * @param m
     * @param n
     * @return
     */
    private boolean stop;
    private ListNode left;

    public void recurseAndReverse(ListNode right, int m, int n) {

        // -----------------------------------
        // 左右指针移动到指定的位置， 属于递 的过程
        if (n == 1) {
            return;
        }

        // 这里每一层的的 right 节点不同，因为是值传递
        right = right.next;

        if (m > 1) {
            this.left = this.left.next;
        }

        // -----------------------------------

        this.recurseAndReverse(right, m - 1, n - 1);

        // 后面属于 归 的过程
        // 这里是终止条件
        if (this.left == right || right.next == this.left) {
            this.stop = true;
        }

        if (!this.stop) {
            // 交换值
            int t = this.left.val;
            this.left.val = right.val;
            right.val = t;

            // 左节点向中间靠拢，右节点在回溯过程中保留的是值，所以回溯过程中自动靠拢
            this.left = this.left.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        this.left = head;
        this.stop = false;
        this.recurseAndReverse(head, m, n);
        return head;
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/fan-zhuan-lian-biao-ii-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
