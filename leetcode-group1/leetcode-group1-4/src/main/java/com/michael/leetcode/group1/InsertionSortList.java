package com.michael.leetcode.group1;

/**
 * 147
 * 对链表进行插入排序。
 * <p>
 * <p>
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * <p>
 *  
 * <p>
 * 插入排序算法：
 * <p>
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        ListNode res = null;
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            res = insert(res, p);
            p = next;
        }

        return res;
    }

    private ListNode insert(ListNode head, ListNode node) {
        if (head == null || head.val > node.val) { // 这里的 > 决定升序或者降序
            node.next = head;
            return node;
        }

        head.next = insert(head.next, node);
        return head;
    }

//        作者：cocowy
//        链接：https://leetcode-cn.com/problems/insertion-sort-list/solution/pai-xu-de-san-chong-si-lu-di-gui-zeng-duan-lian-bi/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


    public static void main(String[] args) {

        InsertionSortList sort = new InsertionSortList();

        ListNode listNode0 = new ListNode(5);
        ListNode listNode1 = new ListNode(6);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(7);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(12);
        ListNode listNode6 = new ListNode(4);

        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode p = listNode0;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }

        System.out.println();

        ListNode p1 = sort.insertionSortList(listNode0);
        while (p1 != null) {
            System.out.print(p1.val + " ");
            p1 = p1.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}