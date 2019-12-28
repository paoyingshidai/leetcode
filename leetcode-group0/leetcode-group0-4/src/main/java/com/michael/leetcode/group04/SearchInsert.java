package com.michael.leetcode.group04;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchInsert {


    /**
     * 循环 时间复杂度 O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
            // 插入到最后
            if (i == nums.length - 1) {
                return nums.length;
            }
        }
        return 0;
    }


    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsertMainint(int[] nums, int target) {
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        return searchInsert(nums, 0, nums.length - 1, target);
    }


    public static int searchInsert(int[] nums, int start, int end, int target) {

        int mid = (start + end) / 2;

        if (start == end) {
            return start;
        }

        if (nums[mid] >= target) {
            return searchInsert(nums, start, mid, target);
        } else {
            return searchInsert(nums, mid + 1, end, target);
        }
    }


    /**
     * 非递归查找
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchIndex(int[] nums, int target) {

        int len = nums.length;

        if (len == 0) {
            return 0;
        }

        int left = 0;
        int right = len;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;         // 这里是 left = mid + 1 还是 right = mid - 1 也是有技巧的，如果是前者，最终的 left 就会多加1
            } else {
                right = mid;
            }
        }
        return left;

//        作者：liweiwei1419
//        链接：https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }


    public static void main(String[] args) {

        int[] data = new int[]{1, 3, 5, 6};
        int[] data2 = new int[]{};

//        System.out.println(searchInsert(data2, 8));

        System.out.println(searchIndex(data, 5));


    }

}
