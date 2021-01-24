package com.michael.leetcode.group1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxProfitTest {

    @Test
    void maxProfit() {

        MaxProfit maxProfit = new MaxProfit();
//        int[] data = {10, 8, 11, 15, 7, 13, 15};
        int[] data = {1,2};

        System.out.println(maxProfit.maxProfit(data));


    }
}