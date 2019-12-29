package com.michael.leetcode.group04;

/**
 * 34
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchRange {


    /**
     * 线性扫描 时间复杂度为 O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if(result[0] == -1) {
                    result[0] = i;
                }
                result[1] = i;
            }
        }
        return result;
    }



    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            // 决定指针向左移还是向右移， 如果目标值小于中间值，或者与中间值相等并且向左，则指针向左边易懂。
            // （可以参考下面的最大值和最小值的做法）  || (left && target == nums[mid]) 这一行是区分向左还是向右的
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            } else {
                lo = mid+1;     // 右边这里加了 1，后面的右边结果需要 - 1
            }
        }

        return lo;
    }


    /**
     *
     作者：LeetCode
     链接：https://leetcode-cn.com/problems/two-sum/solution/zai-pai-xu-shu-zu-zhong-cha-zhao-yuan-su-de-di-yi-/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange2(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // 没有找到最小
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;

        return targetRange;
    }


    /**
     * 查找最早出现的值
     * @param nums
     * @param target
     * @return
     */
    public int searchMin(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length;

        while(lo < hi) {
            int mid = (lo + hi) / 2;

            if(nums[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return nums[lo] == target ? lo : -1;
    }


    /**
     * 查找最晚出现的值 详细的可以参考
     * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/er-fen-cha-zhao-suan-fa-xi-jie-xiang-jie-by-labula/
     * @param nums
     * @param target
     * @return
     */
    public int searchMax(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length;

        while(lo < hi) {
            int mid = (lo + hi) / 2;
            // 与 searchMin 相差了一个 =
            if (nums[mid] > target) {
                hi = mid;
            } else {
                lo = mid+1;     // 右边这里加了 1，后面的右边结果需要 - 1
            }
        }
        return nums[lo-1] == target ? lo-1 : -1;
    }


    public static void main(String[] args) {

        SearchRange range = new SearchRange();
        int[] data = new int[]{5, 7, 8, 8, 8, 8, 8};
        int[] data2 = new int[]{8};
//        range.searchRange(data, 8);
        System.out.println(range.searchMin(data, 1));
        System.out.println(range.searchMax(data, 8));
//        for (int i : range.searchRange2(data, 8)) {
//            System.out.println(i);
//        }

    }
}
