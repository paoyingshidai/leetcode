package com.michael.leetcode.group03;

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }


    public static void main(String[] args) {

        int[] data = {0, 0, 1, 1, 1, 2, 3, 4, 2, 4};

        int result = removeElement(new int[]{}, 2);

        System.out.println(result);
        System.out.println();


        for (int datum : data) {
            System.out.println(datum);
        }

    }

}
