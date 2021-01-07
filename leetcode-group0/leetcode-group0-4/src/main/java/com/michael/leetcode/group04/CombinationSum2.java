package com.michael.leetcode.group04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum2 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrace(candidates, 0, target, new ArrayList<>());
        return result;
    }

    public void backTrace(int[] candidates, int index, int target, List<Integer> temp) {

        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // 防止重复，数组需要重新排序

            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            temp.add(candidates[i]);
            // index+1, 表示不能取自己
            backTrace(candidates, i + 1, target - candidates[i], temp);
            temp.remove(temp.size() - 1);
        }
    }




    public static void main(String[] args) {
        int[] c = {1, 2, 2, 2, 5};
        CombinationSum2 combinationSum2 = new CombinationSum2();
        List<List<Integer>> lists = combinationSum2.combinationSum2(c, 5);

        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
