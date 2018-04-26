package com.michael.jeetcode.group0.listsum;

/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *  输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
	输出：7 -> 0 -> 8
	原因：342 + 465 = 807
 * @author Michael
 */
public class ListSum {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
 		int temp = 0; // 存储两个数相加的进位

		ListNode L1 = l1;
		ListNode L2 = l2;

		ListNode sumList = new ListNode(0);
		ListNode tempList = new ListNode(0);
		tempList = sumList;

		while(!(L1 == null && L2 == null)) {

			int sum = L1.val + L2.val + temp;
			temp = sum/10;

			ListNode sumNext = new ListNode(sum%10);
			tempList.next = sumNext;
			tempList = tempList.next;

			L1 = L1.next;
			L2 = L2.next;

			// 判断是否结束, 结束后如果有进位需要添加进位
			if ((L1 == null && L2 == null) && temp != 0) {
				tempList.next = new ListNode(temp);
			}

			if (L1 == null && L2 != null) {
				L1 = new ListNode(0);
			}
			if (L2 == null && L1 != null) {
				L2 = new ListNode(0);
			}
		}

		return sumList.next;
    }


	public static void main(String[] args) {

		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		n2.next = n3;
		n1.next = n2;

		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(6);
		ListNode l3 = new ListNode(4);
		ListNode l4 = new ListNode(9);
		l3.next = l4;
		l2.next = l3;
		l1.next = l2;


//		ListNode k1 = new ListNode(5);
//		ListNode k2 = new ListNode(5);

		ListNode sumList = ListSum.addTwoNumbers(l1, n1);
//		ListNode sumList = ListSum.addTwoNumbers(k1, k2);

//		sumList.printValue();

		while (sumList != null) {
			System.out.println(sumList.val);
			sumList = sumList.next;
		}
	}
}

