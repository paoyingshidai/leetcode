package com.michael.leetcode.group5;

public class FindMin {

    /**
     * 滑动指针
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int start = 0, end = 1;

        int result = nums[0];

        while(end < nums.length) {
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

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/xun-zhao-xuan-zhuan-pai-lie-shu-zu-zhong-de-zui-xi/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

        public static void main(String[] args) {

        FindMin findMin = new FindMin();

//        int[] data = new int[]{4, 5, 6, 7, 0, 1, 2};

        int[] data = new int[]{};

        System.out.println(findMin.findMin(data));

    }

}
