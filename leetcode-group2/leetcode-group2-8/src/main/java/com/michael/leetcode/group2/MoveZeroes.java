package com.michael.leetcode.group2;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 通过次数300,100提交次数471,987
 */
public class MoveZeroes {

    /**
     * 冒泡
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {

        int i = 0;
        int len = nums.length;
        int count = 0;

        while (i < len) {

            if (nums[i] == 0) {
                int temp = nums[i];
                count++;

                int j = i + 1;
                while (j < len) {
                    nums[j - 1] = nums[j];
                    j++;
                }
                nums[j - 1] = temp;
            }
            if (i == len + 1 - count) {
                break;
            }
            if (nums[i] != 0) {
                i++;
            }
        }
    }

    /**
     * 两次遍历 参考 27 题
     *
     * @param nums
     */
    public void moveZeroes2(int[] nums) {

        if (nums.length == 0) {
            return;
        }

        int i = 0, j = 0;
        int len = nums.length;

        while (j < len) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }

        while (i < len) {
            nums[i] = 0;
            i++;
        }
    }

    /**
     * 一次遍历
     *
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

//    作者：wang_ni_ma
//    链接：https://leetcode-cn.com/problems/move-zeroes/solution/dong-hua-yan-shi-283yi-dong-ling-by-wang_ni_ma/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
