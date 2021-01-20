package com.michael.leetcode.group6;

/**
 * 605. 种花问题
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] 为 0 或 1
 * flowerbed 中不存在相邻的两朵花
 * 0 <= n <= flowerbed.length
 *
 * @author Michael
 */
public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int sum = 0;
        int countZero = 0;

        if (flowerbed.length == 2) {
            if (flowerbed[0] == 0 && flowerbed[1] == 0) {
                sum = sum + 1;
            }
        } else if (flowerbed.length == 1) {
            if (flowerbed[0] == 0) {
                sum = sum + 1;
            }
        }

        if (flowerbed.length >= 3 && flowerbed[0] == 0 && flowerbed[1] == 0 && flowerbed[2] == 1) {
            sum = sum + 1;
        }

        int len = flowerbed.length;

        if (flowerbed.length >= 3 && flowerbed[len - 1] == 0 && flowerbed[len - 2] == 0 && flowerbed[len - 3] == 1) {
            sum = sum + 1;
        }


        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                sum = sum + (countZero - 1) / 2;
                countZero = 0;
            } else {
                countZero++;
            }
        }
        sum = sum + (countZero - 1) / 2;
        System.out.println(sum);
        return sum >= n;
    }

    public static void main(String[] args) {
        CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();

//        int[] data = new int[]{1, 0, 0, 0, 0, 0, 1};
//        int[] data = new int[]{0, 0, 1, 0, 1, 0, 0};
        int[] data = new int[]{1, 0};

        System.out.println(canPlaceFlowers.canPlaceFlowers(data, 1));

    }

}
