package com.michael.leetcode.group2;

public class MinSubArrayLen {

        private int res = Integer.MAX_VALUE;

    /**
     * 滑动窗口
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null)
            return 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        while(right < nums.length){
            sum += nums[right];
            while(left <= right && sum >= s) {
                res = Math.min(res,right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        if(res == Integer.MAX_VALUE)
            return 0;
        return res;
    }

//    作者：horanol
//    链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/java-hua-dong-chuang-kou-4ms-by-horanol/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


    /**
     * 这种连续的数组或者字符串可以使用滑动窗口
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen2(int s, int[] nums) {
        if (nums.length == 0) return 0;

        int left = 0;
        int right = 0;
        int sum = 0;

        while(right < nums.length) {
            sum += nums[right];
            while(left <= right && sum >= s) {
                    res = Math.min(res, right - left + 1);
                    sum -= nums[left];
                    left++;
            }
            right++;
        }

        return res;
    }

}
