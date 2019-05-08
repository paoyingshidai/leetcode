package com.michael.jeetcode.group0.sum;

import java.util.HashMap;
import java.util.Map;

/**
*
* 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
* 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
* @author windows
*
*/
public class Sum {

	/**
	 * 时间复杂度为 O(n*n)
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 1; j < nums.length; j++) {
				if (i != j) {
					int sum = nums[i] + nums[j];
					if (sum == target) {
						result[0] = i;
						result[1] = j;
					}
				}
			}
		}
		return result;
    }


	/**
	 * 一遍哈希 时间复杂度为O(n)
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public static void main(String[] args) {

		int[] nums = {1,5,3,4};
		int target = 9;

		int[] result = Sum.twoSum2(nums, target);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
