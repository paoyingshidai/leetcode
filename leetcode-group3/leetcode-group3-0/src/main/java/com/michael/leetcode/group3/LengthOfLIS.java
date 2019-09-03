package com.michael.leetcode.group3;

/**
 * 300. 最长上升子序列
 *
 * 题目描述
 * 评论 (143)
 * 题解(30)New
 * 提交记录
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class LengthOfLIS {

    /**
     * 滑动窗口
     * @param nums
     * @return
     */
    private int res = 0;
    public int lengthOfLIS(int[] nums) {

        int left  = 0;
        int right  = 1;

        while(right < nums.length) {

            if (nums[right-1] < nums[right]) {
                res = Math.max(res, right - left + 1);
            } else {
                left = right;
            }
            right++;
        }

        return res;
    }

    public static void main(String[] args) {

        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        int[] data = new int[]{10,9,2,5,3,7,101,18};

        System.out.println(lengthOfLIS.lengthOfLIS(data));
    }


}
