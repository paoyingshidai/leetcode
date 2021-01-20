package com.michael.leetcode.group6;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class CanPlaceFlowersTest {


    @DisplayName("测试")
    @ParameterizedTest
    @MethodSource("argsProvider")
    public void test(int result, int[] data) {

        CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();

        boolean b = canPlaceFlowers.canPlaceFlowers(data, result);

        Assertions.assertTrue(b);

    }

    static Stream<Arguments> argsProvider() {
        return Stream.of(
                        arguments(1, new int[]{1, 0, 0, 0},
                        arguments(0, new int[]{1, 0}
                        )
                )

        );
    }

}