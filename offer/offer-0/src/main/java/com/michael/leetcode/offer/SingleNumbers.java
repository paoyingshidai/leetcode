package com.michael.leetcode.offer;

import java.util.Arrays;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 *
 * 限制：
 *
 * 2 <= nums.length <= 10000
 * @author Michael
 */
public class SingleNumbers {

    public int[] singleNumbers(int[] nums) {

        Arrays.sort(nums);

        int[] result = new int[]{0, 0};

        boolean same = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {

                if (!same) {
                    if (result[0] == 0) {
                        result[0] = nums[i];
                    } else {
                        result[1] = nums[i];
                    }
                }
                same = false;
            } else {
                same = true;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        SingleNumbers singleNumbers = new SingleNumbers();
        int[] data = {4, 1, 4, 6};

        int[] ints = singleNumbers.singleNumbers(data);

        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }


}
