package com.michael.leetcode.offer;

import java.util.Arrays;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 *
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 50000
 * @author Michael
 */
public class MajorityElement {


    public int majorityElement(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        Arrays.sort(nums);

        int len = nums.length / 2;

        int l = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {
                l++;
            } else {
                l = 1;
            }

            if (l == len) {
                return nums[i];
            }
        }
        return 0;
    }

    public int majorityElement2(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        Arrays.sort(nums);

        int len = nums.length / 2;

        return nums[len];
    }

    /**
     * 摩尔投票法
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;

//        作者：jyd
//        链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }


}
