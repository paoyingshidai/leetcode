package com.michael.leetcode.group1;

/**
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2:
 *
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 * 说明:
 *
 * 你的解法应该是 O(logN) 时间复杂度的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-peak-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindPeakElement {

    /**
     * 线性扫描 时间复杂度 O(n)
     * @param nums
     * @return
     */
    public int findPeakElement1(int[] nums) {

        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] < nums[i]) {
                result = i;
                continue;
            }

            if (nums[i-1] > nums[i] || i == nums.length - 1) {
                result = i - 1;
                break;
            }

        }
        return result;
    }



    public int findPeakElement(int[] nums) {

        if (nums.length == 1) return 0;

        int lo = 0;
        int hi = nums.length - 1;

        while(lo < hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] > nums[mid+1]) {
                hi = mid;
            } else if (nums[mid] < nums[mid+1]) {
                lo = mid + 1;
            } else if (nums[mid] == nums[mid+1]) {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        FindPeakElement element = new FindPeakElement();

        int[] data = new int[]{1, 2, 1, 3, 5, 6, 4};
        int[] data2 = new int[]{1,2};
        System.out.println(element.findPeakElement1(data));
        System.out.println(element.findPeakElement(data));

        System.out.println();
        System.out.println(element.findPeakElement1(data2));
        System.out.println(element.findPeakElement(data2));
    }
}
