package com.michael.leetcode.gorup02;

import java.util.List;

public class RemoveNthFromEnd {

    /**
     *
     * @param head 头结点
     * @param n 倒数第 n 个节点
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode temp = head;
        ListNode last = head;

        while(last.next != null) {
            if (n <= 0) {
                temp = temp.next;
            }
            last = last.next;
            n--;
        }

        if (n == 1) {
            return head.next;
        }

        temp.next = temp.next.next;
        return head;
    }

    public static void main(String[] args) {


        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

//        System.out.println(removeNthFromEnd(node1, 2));

        ListNode temp = removeNthFromEnd(node1, 5);
//        ListNode temp = node1;
        while (temp.next != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
        System.out.println(temp.val);



    }


    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

}
