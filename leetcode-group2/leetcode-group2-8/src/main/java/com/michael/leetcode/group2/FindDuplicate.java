package com.michael.leetcode.group2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindDuplicate {

    /**
     * 线性扫描
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {

        Set set = new HashSet();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        return 0;
    }


    /**
     * Floyd 龟兔赛跑算法（最快）
     * 参考博客：https://www.jianshu.com/p/a821b0a15b51
     * @param nums
     * @return
     */
    public int findDuplicate3(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];  // 乌龟走一步
            hare = nums[nums[hare]];    // 兔子走两步
        } while (tortoise != hare);     // 找到交叉点， 龟兔相遇，这个点不一定是环的开头

        // Find the "entrance" to the cycle.    找到循环的入口
        int ptr1 = nums[0];             // 乌龟返回链表开头
        int ptr2 = tortoise;            // 兔子留在原地，然后等速推进
        while (ptr1 != ptr2) {          // 因为 ptr1 != ptr2, 所以，如果 nums[ptr1] = nums[ptr2], 则必定存在两个数相等
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }


    /**
     * 排序法
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == nums[i]) return nums[i];
        }
        return 0;
    }


    public static void main(String[] args) {
        FindDuplicate duplicate = new FindDuplicate();
//        int[] data = new int[]{1, 4, 6, 6, 6, 2, 3};
        int[] data = new int[]{1,2,1};

//        System.out.println(duplicate.findDuplicate2(data));
        System.out.println(duplicate.findDuplicate3(data));
    }

}