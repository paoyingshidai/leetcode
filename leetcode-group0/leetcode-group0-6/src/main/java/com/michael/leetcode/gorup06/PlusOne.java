package com.michael.leetcode.gorup06;

/**
 * 66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 * <p>
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 * <p>
 * 输入：digits = [0]
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 * @author Michael
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {

        int len = digits.length;
        int k = 0;
        boolean first = true;
        for (int i = len - 1; i >= 0; i--) {

            int sum;
            if (first) {
                sum = digits[i] + 1;
                first = false;
            } else {
                sum = digits[i] + k;
            }

            int mod = sum % 10;
            k = sum / 10;

            digits[i] = mod;
            
            if (k == 0) {
                return digits;
            }
        }

        if (k == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }

        return digits;
    }

    public static void main(String[] args) {

        PlusOne plusOne = new PlusOne();
//        int[] data = {9, 9, 9};
        int[] data = {9};

        int[] ints = plusOne.plusOne(data);

        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }
}
