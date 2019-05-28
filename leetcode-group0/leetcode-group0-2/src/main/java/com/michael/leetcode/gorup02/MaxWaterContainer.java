package com.michael.leetcode.gorup02;

/**
 * 最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/solution/sheng-zui-duo-shui-de-rong-qi-by-leetcode/
 */
public class MaxWaterContainer {

    /**
     * 暴力的方法是两个循环对比最大面积
     *
     * 但是这个方法是O(n), 两个维度，这个方法的思路是穷举距离的所有最大面积情况，
     * 即 在距离为 n 时，最大面积是多少，然后逐步向中间靠拢
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }


    public static void main(String[] args) {



    }

}
