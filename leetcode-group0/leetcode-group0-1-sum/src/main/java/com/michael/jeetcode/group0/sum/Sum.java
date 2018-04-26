package com.michael.jeetcode.group0.sum;

/**
*
* 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
* 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
* @author windows
*
*/
public class Sum {

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

	public static void main(String[] args) {

		int[] nums = {1,5,3,4};
		int target = 9;

		int[] result = Sum.twoSum(nums, target);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
