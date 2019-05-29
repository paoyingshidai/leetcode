package com.michael.leetcode.group03;

public class MergeTwoLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode rspHead=new ListNode(0);
        ListNode rsp=rspHead;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                rspHead.next=l1;
                l1=l1.next;
            }else{
                rspHead.next=l2;
                l2=l2.next;
            }
            rspHead=rspHead.next;
        }
        if(l1==null){
            rspHead.next=l2;
        }else{
            rspHead.next=l1;
        }
        return rsp.next;
    }


    public static void main(String[] args) {
//        ListNode node1 = new ListNode(1);
        ListNode node1 = new ListNode(-9);
        ListNode node2 = new ListNode(3);
//        ListNode node3 = new ListNode(5);
//        ListNode node4 = new ListNode(7);

        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;

        ListNode node11 = new ListNode(5);
        ListNode node12 = new ListNode(7);
//        ListNode node13 = new ListNode(6);
//        ListNode node14 = new ListNode(8);

        node11.next = node12;
//        node12.next = node13;
//        node13.next = node14;

        ListNode result = mergeTwoLists(node1, node11);

        while (result.next != null) {
            System.out.println(result.val);
            result = result.next;
        }
        System.out.println(result.val);

    }



    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
