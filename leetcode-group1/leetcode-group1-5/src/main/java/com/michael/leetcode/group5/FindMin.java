package com.michael.leetcode.group5;

public class FindMin {

    /**
     * 滑动指针
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {

        int length = nums.length;

        if (length == 0) return 0;
        if (length == 1) return nums[0];

        int start = 0, end = 1;

        int result = nums[0];

        while (end < length) {
            if (nums[start] > nums[end]) {
                return nums[end];
            } else {
                start++;
                end++;
            }
        }
        return result;
    }


    public int findMin2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0, right = nums.length - 1;
        if (nums[right] > nums[0]) {
            return nums[0];
        }

        while (right >= left) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            // 这里主要确定易懂的方向，中间元素与第一个元素对比，如果大于第一个元素，证明旋转点在中间点的右边，否则在左边
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 存在重复的情况
     *
     * 这个解法可以画图表示，通过中间点的大小与右边的大小进行比较来确定往哪一遍靠拢
     *
     * @param nums
     * @return
     */
    public int findMin3(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else if (nums[mid] < nums[right]) right = mid;
            else right = right - 1;
        }
        return nums[left];

//        作者：jyd
//        链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/solution/154-find-minimum-in-rotated-sorted-array-ii-by-jyd/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/xun-zhao-xuan-zhuan-pai-lie-shu-zu-zhong-de-zui-xi/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static void main(String[] args) {

        FindMin findMin = new FindMin();

//        int[] data = new int[]{ 0, 1, 2, 4, 5, 6, 7};
//        int[] data = new int[]{4, 5, 6, 7, 0, 1, 2};

//        int[] data = new int[]{3,3,3,2};
//        int[] data = new int[]{2,2,2,3};
//        int[] data = new int[]{2,2,2};
        int[] data = new int[]{0, 1, 1, 3, 1};

        System.out.println(findMin.findMin2(data));

    }

}
