package com.michael.leetcode.group0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubsetsWithDup {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        backTrace2(nums, 0, new LinkedList<>());
        return result;
    }

    /**
     * 做重复剪枝，重复的情况有多种：1：元素的重复，2：index 的重复， 3：结果的去重
     * 1:元素的去重可以使用排序然后在比较与之前的值是否相等，nums[i] == nums[i-1]
     * 2:index 的去重，可以使用另外一个 boolean 数组记录位置是否被使用。可参考PermuteUnique，全排列二
     *
     * @param nums
     * @param index
     * @param temp
     */
    public void backTrace2(int[]nums, int index, LinkedList<Integer> temp) {
        // 如果这里没有做限制的话，它会添加所有子集
        result.add(new LinkedList<>(temp));

        System.out.println(temp);
        for (int i = index; i < nums.length; i++) {

            // 这个地方需要控制重复组合
            if (i > index && nums[i] == nums[i-1]) {
                continue;
            }

            temp.add(nums[i]);
            // index 控制是否可以使用相同元素多次
            backTrace2(nums,i+1, temp);
            temp.removeLast();
        }
    }
}
