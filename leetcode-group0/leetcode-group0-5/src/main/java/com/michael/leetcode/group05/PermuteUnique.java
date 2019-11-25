package com.michael.leetcode.group05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PermuteUnique {

    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] used;         //   这个 boolean 数组用于在循环的时候进行剪枝处理

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        // 修改 1：首先排序，之后才有可能发现重复分支
        Arrays.sort(nums);
        used = new boolean[len];
        findPermuteUnique(nums, 0, new Stack<>());
        return res;
    }

    /**
     * 官方解题， 注意回溯算法的剪枝处理
     * @param nums
     * @param depth
     * @param stack
     */
    private void findPermuteUnique(int[] nums, int depth, Stack<Integer> stack) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {      // 剪枝 1， 位置不能够重复使用
                // 修改 2：因为排序以后重复的数一定不会出现在开始，故 i > 0
                // 和之前的数相等，并且之前的数还未使用过，只有出现这种情况，才会出现相同分支
                // 这种情况跳过即可
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {  // 剪枝 2， 与上一个相等并且上一个没有被使用过， 如果值相等，则不可取回头的数（已经有排序的前提）
                    continue;
                }
                used[i] = true;
                stack.add(nums[i]);
                findPermuteUnique(nums, depth + 1, stack);
                stack.pop();
                used[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2};
        PermuteUnique solution = new PermuteUnique();
        List<List<Integer>> permuteUnique = solution.permuteUnique(nums);
        System.out.println(permuteUnique);
    }

}
