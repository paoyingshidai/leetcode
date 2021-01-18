package com.michael.leetcode.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 *
 * 限制：
 *
 * 2 <= n <= 100000
 * @author Michael
 */
public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {

        // value, index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer value = map.get(nums[i]);
            if (value != null) {
                return nums[value];
            } else {
                map.put(nums[i], i);
            }
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {

        if (nums != null && nums.length == 1) {
            return -1;
        }
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindRepeatNumber findRepeatNumber = new FindRepeatNumber();

        int[] data = {2, 3, 1, 0, 2, 5, 3};

        int repeatNumber = findRepeatNumber.findRepeatNumber(data);
        System.out.println(repeatNumber);

    }
}
