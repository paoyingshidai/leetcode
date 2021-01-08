package com.michael.leetcode.group03;

/**
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 */
public class ReverseKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;


        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            // 间隔为 K
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            // 切断链表
            end.next = null;
            // 反转链表，并且将其挂载到上一段链上
            pre.next = reverseList(start);
            // 经过反转后，start 已经变成最后一节，将后面的挂载到这一节的后面

            start.next = next;
            // 重置滑动指针
            pre = start;
            end = pre;
        }
        return dummy.next;

//        作者：user7208t
//        链接：https://leetcode-cn.com/problems/two-sum/solution/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
    /**
     * 反转链表
     * @param head
     * @return
     *
     * 解释：https://blog.csdn.net/qq_42351880/article/details/88637387
     *
     */
    public static ListNode reverseList(ListNode head) {

        ListNode cur = head;
        ListNode pre = null;

        while(cur != null) {
            ListNode next = cur.next;   // 断开
            cur.next = pre;             // 链接下一个元素
            pre = cur;                  // 移动 pre 指针
            cur = next;                 // 下一个周期
        }
        return pre;                     // 最后是返回 pre, 因为此时，cur == null
    }

    public static void main(String[] args) {

        ListNode result1 = new ListNode(0);
        ListNode r1 = result1;

        for (int i = 1; i <= 9; i++) {
            if (i % 2 == 0) {
                result1.next = new ListNode(i);
                result1 = result1.next;
            }
        }

        printList(r1);

//        ListNode result = reverseKGroup(r1, 2);
//        printList(result);

//        printList(r1);
//
//        r1 = reverseList(r1);
//
//        System.out.println("after reverse");
//
//        printList(r1);

    }


    /**
     * 打印链表
     * @param head
     */
    public static void printList(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        printList(head.next);
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
