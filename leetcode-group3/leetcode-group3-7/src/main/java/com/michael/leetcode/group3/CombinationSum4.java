package com.michael.leetcode.group3;

/**
 * 377
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 *
 * 示例:
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * 请注意，顺序不同的序列被视作不同的组合。
 *
 * 因此输出为 7。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum4 {

    int i = 0;

    public int combinationSum4(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        combinationSum4(nums, 0, target);
        return i;
    }

    public void combinationSum4(int[] nums, int beforeRe, int target) {
        if (beforeRe > target) {
            return;
        }
        if (beforeRe == target) {
            i++;
            return;
        }
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int tempRe = beforeRe + nums[i];
            combinationSum4(nums, tempRe, target);
        }
    }

//    作者：niu-you-rou
//    链接：https://leetcode-cn.com/problems/combination-sum-iv/solution/di-gui-dao-fen-zhi-dao-dong-tai-gui-hua-by-niu-you/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
