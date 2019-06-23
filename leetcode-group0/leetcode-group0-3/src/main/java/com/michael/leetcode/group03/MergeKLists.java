package com.michael.leetcode.group03;

public class MergeKLists {

    //    作者：user9827R
    //    链接：https://leetcode-cn.com/problems/two-sum/solution/he-bing-k-ge-pai-xu-lian-biao-by-user9827r/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        // 归并
        return solve(lists, 0, lists.length-1);
    }

    private static ListNode solve(ListNode[] arr, int left, int right) {
        if(left == right)
            return arr[left];

        int mid = (left + right) >> 1;
        ListNode lNode = solve(arr, left, mid);
        ListNode rNode = solve(arr, mid+1, right);

        return merge(lNode, rNode);
    }

    private static ListNode merge(ListNode node1, ListNode node2) {
        if(node1 == null)
            return node2;
        if(node2 == null)
            return node1;

        if(node1.val < node2.val) {
            node1.next = merge(node1.next, node2);
            return node1;
        } else {
            node2.next = merge(node1, node2.next);
            return node2;
        }

    }


    public static void main(String[] args) {


        ListNode result1 = new ListNode(0);
        ListNode r1 = result1;
        ListNode result2 = new ListNode(0);
        ListNode r2 = result2;


        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                result1.next = new ListNode(i);
                result1 = result1.next;
            }
        }

        for (int i = 0; i <= 10; i++) {
            if (i % 2 == 1) {
                result2.next = new ListNode(i);
                result2 = result2.next;
            }
        }

        ListNode resul1 = r1;
        while(resul1 != null) {
            System.out.println(resul1.val);
            resul1 = resul1.next;
        }
//
//        while(r2 != null) {
//            System.out.println(r2.val);
//            r2 = r2.next;
//        }

        ListNode[] listNodes = {r1.next, r2.next};

        ListNode node = mergeKLists(listNodes);
//        ListNode node = new ListNode(0);


        while(node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
