package com.michael.leetcode.group0;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Subsets {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {

        backTrace2(nums, 0, new LinkedList<>());
        return result;
    }

    /**
     * @param nums
     * @param index
     * @param k     // 元素个数
     * @param temp
     */
    public void backTrace(int[] nums, int index, int k, LinkedList<Integer> temp) {
        if (temp.size() == k) {
            result.add(new LinkedList<>(temp));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            backTrace(nums, i + 1, k, temp);
            temp.removeLast();
        }
    }

    public void backTrace2(int[] nums, int index, LinkedList<Integer> temp) {
        // 如果这里没有做限制的话，它会添加所有子集
        result.add(new LinkedList<>(temp));

        for (int i = index; i < nums.length; i++) {
            // 这个地方需要控制重复组合
            temp.add(nums[i]);
            // index 控制是否可以使用相同元素多次
            backTrace2(nums, i + 1, temp);
            temp.removeLast();
        }
    }

    /**
     * []
     * [1]
     * [1, 2]
     * [1, 2, 3]
     * [1, 3]
     * [2]
     * [2, 3]
     * [3]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3};
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(data));
    }
}
