package com.michael.leetcode.group16;

/**
 * 1669. 合并两个链表
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 *
 * 请你将 list1 中第 a 个节点到第 b 个节点删除，并将list2 接在被删除节点的位置。
 *
 * 下图中蓝色边和节点展示了操作后的结果：
 *
 *
 * 请你返回结果链表的头指针。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * 输出：[0,1,2,1000000,1000001,1000002,5]
 * 解释：我们删除 list1 中第三和第四个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
 * 示例 2：
 *
 *
 * 输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
 * 输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
 * 解释：上图中蓝色的边和节点为答案链表。
 *
 *
 * 提示：
 *
 * 3 <= list1.length <= 104
 * 1 <= a <= b < list1.length - 1
 * 1 <= list2.length <= 104
 * @author Michael
 */
public class MergeInBetween {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        int i = 0;
        ListNode head = new ListNode(-1);
        head.next = list1;
        ListNode pre = head;
        ListNode cur = list1;

        ListNode list2Cur = list2;

        while (cur != null) {

            if (i == a) {
                pre.next = list2;
                while (list2Cur.next != null) {
                    list2Cur = list2Cur.next;
                }
            }
            if (i == b + 1) {
                list2Cur.next = cur;
                break;
            }

            i++;
            pre = cur;
            cur = cur.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(-1);
        ListNode cur1 = head1;
        for (int i = 0; i <= 5; i++) {
            cur1.next = new ListNode(i);
            cur1 = cur1.next;
        }

        ListNode head2 = new ListNode(9);
        ListNode cur2 = head2;
        for (int i = 10; i < 15; i++) {
            cur2.next = new ListNode(i);
            cur2 = cur2.next;
        }

        MergeInBetween merge = new MergeInBetween();
        ListNode listNode = merge.mergeInBetween(head1.next, 3, 4, head2);

        ListNode cur = listNode;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }

    }

     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }

         @Override
         public String toString() {
             return "ListNode{" +
                     "val=" + val +
                     ", next=" + next +
                     '}';
         }
     }

}
