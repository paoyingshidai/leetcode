package com.michael.leetcode.group1;

/**
 * 143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class ReorderList {

    ListNode cur;
    ListNode h;
    boolean end = false;

    /**
     * 这是递归法，内存消耗比较大
     * 可以参考官网
     * // 作者：LeetCode-Solution
     * // 链接：https://leetcode-cn.com/problems/reorder-list/solution/zhong-pai-lian-biao-by-leetcode-solution/
     * // 来源：力扣（LeetCode）
     * // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param head
     */
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        int N = 0;
        ListNode node = head;
        while (node != null) {
            N++;
            node = node.next;
        }

        cur = head;
        h = head;
        doRecordList(head, N/2);
    }

    public void doRecordList(ListNode head, int mid) {

        if (head == null) {
            return;
        }

        ListNode temp = head.next;
        if (mid == 0) {
            head.next = null;
            doRecordList(temp, 0);
        } else {
            doRecordList(head.next, mid - 1);
        }

        if (cur == head || cur.next == head) {
            end = true;
            return;
        } else {
            if (!end) {
                ListNode next = cur.next;
                cur.next = head;
                cur.next.next = next;
                cur = cur.next.next;
            }
        }
    }


    public static void main(String[] args) {

        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for (int i = 1; i <= 4; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }

        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(head.next);

        System.out.println(head);

    }



     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
