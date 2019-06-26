package com.michael.leetcode.group03;

public class RemoveDuplicates {

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

        int result = removeDuplicates(new int[]{});

        System.out.println(result);
        System.out.println();


        for (int datum : data) {
//            System.out.println(datum);
        }

    }

}
