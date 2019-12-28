package com.michael.leetcode.group03;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicates {

    /**
     * 去除重复元素
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;

//        作者：LeetCode
//        链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-xiang-by-/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

    public static int[] removeDuplicates3(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            if (nums[j] == nums[i]) {
                int k = i;
                while (k < nums.length) {
                    nums[k - 1] = nums[k];
                    k++;
                }
            }
        }

        return nums;
    }

    public static int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int i = 0;  // 头下标
        int j = 0;
        for (int i1 = 0; i1 < nums.length; i1++) {
            j = i1;
            if (nums[i] == nums[j]) {
                nums[i] = nums[j];
            } else {
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }


    public static void main(String[] args) {

        int[] data = {0, 0, 1, 1, 1, 2, 3, 4, 4, 4};

//        int result = removeDuplicates(new int[]{});
//        int result = removeDuplicates(data);

        removeDuplicates3(data);

//        System.out.println(result);
        System.out.println();


        for (int datum : data) {
            System.out.printf("%d,", datum);
        }

    }

}
