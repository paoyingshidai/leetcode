package com.michael.leetcode.group05;

import java.util.*;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permute {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>(), new HashSet<>());
        return res;
    }


    public void backtrack(int[] nums, List<Integer> temp, Set<Integer> persition) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i1 = 0; i1 < nums.length; i1++) {
            if (persition.contains(i1)) continue;   // 回溯算法的剪枝问题 (位置被访问过就不能访问)

            persition.add(i1);
            temp.add(nums[i1]);
            backtrack(nums, temp, persition);
            temp.remove(temp.size() - 1);
            persition.remove(i1);
        }
    }

    /**
     * 官方，更优
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> output = new LinkedList();

        ArrayList<Integer> nums_lst = new ArrayList<>();
        for (int num : nums) {
            nums_lst.add(num);
        }

        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;
    }

    public void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> output, int first) {

        if (first == n) output.add(new ArrayList<>(nums));

        for (int i = first; i < n; i++) {
            // 交换
            Collections.swap(nums, first, i);
            backtrack(n, nums, output, first + 1);
            // 复原
            Collections.swap(nums, first, i);
        }
    }


    public static void main(String[] args) {

        Permute permute = new Permute();

        int[] data = new int[]{1, 2, 3, 4};

        List<List<Integer>> result = permute.permute2(data);

        for (List<Integer> integers : result) {
            System.out.println(integers);
        }
    }
}
