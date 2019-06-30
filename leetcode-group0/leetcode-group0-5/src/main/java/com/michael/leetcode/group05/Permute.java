package com.michael.leetcode.group05;

import java.util.*;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permute {


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new ArrayList<>(), new HashSet<>());
        return res;
    }


    public void backtrack(int[] nums, List<List<Integer>> res, List<Integer> temp, Set<Integer> persition) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i1 = 0; i1 < nums.length; i1++) {
            if (persition.contains(i1)) continue;   // 回溯算法的剪枝问题

            persition.add(i1);
            temp.add(nums[i1]);
            backtrack(nums, res, temp, persition);
            temp.remove(temp.size() - 1);
            persition.remove(i1);
        }
    }


    public static void main(String[] args) {

        Permute permute = new Permute();

        int[] data = new int[]{1,2,3};

        List<List<Integer>> result = permute.permute(data);

        System.out.println(result);

    }
}
