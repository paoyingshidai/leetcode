package com.michael.leetcode.group03;

public class SwapPairs {

    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next != null) {
            ListNode a = head.next.next;
            ListNode next = head;
            head = head.next;
            head.next = next;
            head.next.next = swapPairs(a);
            return head;
        } else {
            return head;
        }
    }


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

    public static void main(String[] args) {

        ListNode result1 = new ListNode(0);
        ListNode r1 = result1;

        for (int i = 1; i <= 9; i++) {
            if (i % 2 == 0) {
                result1.next = new ListNode(i);
                result1 = result1.next;
            }
        }

        ListNode result = swapPairs(r1);
        printList(result);

    }

}
