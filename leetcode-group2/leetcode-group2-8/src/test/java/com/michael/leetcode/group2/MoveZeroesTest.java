package com.michael.leetcode.group2;

import org.junit.jupiter.api.Test;

class MoveZeroesTest {

    @Test
    void moveZeroes() {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] data = {0, 1,0,0, 3, 9, 3};
        moveZeroes.moveZeroes2(data);

        for (int datum : data) {
            System.out.println(datum);
        }

    }
}