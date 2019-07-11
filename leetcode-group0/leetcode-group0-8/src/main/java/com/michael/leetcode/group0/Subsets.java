package com.michael.leetcode.group0;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Subsets {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        for (int k = 0; k <= nums.length; k++) {
            backTrace(nums, 0, k, new LinkedList<>());
        }
        return result;
    }

    /**
     *
     * @param nums
     * @param index
     * @param k     // 元素个数
     * @param temp
     */
    public void backTrace(int[]nums, int index, int k, LinkedList<Integer> temp) {
        if (temp.size() == k) {
            result.add(new LinkedList<>(temp));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            backTrace(nums,i+1, k, temp);
            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{1,2,3};
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(data));
    }
}
