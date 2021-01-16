package com.michael.leetcode.group3;

import java.util.Random;

/**
 * @author Michael
 */
public class RandomList {

    ListNode head = null;
    Random rd;

    public RandomList(ListNode head) {
        this.head = head;
        this.rd = new Random();
    }

    /**
     * https://leetcode-cn.com/problems/linked-list-random-node/solution/xu-shui-chi-chou-yang-suan-fa-reservoir-jvnmc/
     * @return
     */
    public int getRandom() {
        int ans = 0;
        int cnt = 0;
        ListNode p = head;
        while(p != null) {
            if(rd.nextInt(++cnt) == 0) {
                ans = p.val;
            }
            p = p.next;
        }
        return ans;
    }

//    作者：bock123
//    链接：https://leetcode-cn.com/problems/linked-list-random-node/solution/xu-shui-chi-chou-yang-suan-fa-reservoir-jvnmc/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
