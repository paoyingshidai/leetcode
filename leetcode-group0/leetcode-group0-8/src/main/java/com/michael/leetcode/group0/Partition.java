package com.michael.leetcode.group0;

/**
 * 86. 分隔链表
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 *
 *
 * 示例：
 *
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 * 通过次数84,632提交次数135,887
 */
public class Partition {

    public ListNode partition(ListNode head, int x) {

        if (head == null) {
            return head;
        }
        ListNode pro = head;
        ListNode big = new ListNode(-1);
        ListNode small = new ListNode(-1);
        ListNode headbig = big;
        ListNode headsmall = small;
        //分
        while (pro!= null) {
            //大于时，放到 big 链表上
            if (pro.val >= x) {
                big.next = pro;
                big = big.next;
                // 小于放到 small 链表上
            }else {
                small.next = pro;
                small = small.next;
            }
            pro = pro.next;
        }
        //细节
        big.next = null;
        //合
        small.next = headbig.next;
        return headsmall.next;

//        作者：tan45du
//        链接：https://leetcode-cn.com/problems/partition-list/solution/yi-miao-jiu-neng-kan-dong-de-dong-hua-xi-dubr/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

}
