package com.michael.leetcode.group04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, res, 0, new ArrayList<>());
        return res;
    }

    /**
     *
     * @param candidates    数据
     * @param target        和
     * @param res           结果集
     * @param start         指针的位置
     * @param tempList      由上一层传递下来的保存部分结果的列表
     */
    private static void backtrack(int[] candidates, int target, List<List<Integer>> res, int start, ArrayList<Integer> tempList) {
        if (target < 0) return;     // 不符合的，则返回， 这里并不是判断他的深度
        if (target == 0) {          // 符合条件的
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {

            if (target < candidates[i]) break;      // 剪枝，如果候选值比目标值大，则寻找下一个

            tempList.add(candidates[i]);            // 先加入列表
            backtrack(candidates, target - candidates[i], res, i, tempList);    // 更深一层
            tempList.remove(tempList.size() - 1);   // 下面一层处理完后，处理当前层的下一个前，将前面添加的元素移除
        }
    }

    public static void main(String[] args) {



    }

}
