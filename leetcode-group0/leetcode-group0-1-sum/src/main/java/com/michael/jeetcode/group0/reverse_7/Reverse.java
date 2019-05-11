package com.michael.jeetcode.group0.reverse_7;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 整数反转
 *
 */
public class Reverse {

    /**
     * 解题思路
     *
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
//        List<Integer> storage = new ArrayList<>();
        List<Integer> storage = new ArrayList<>();
        int n = x;
        boolean lessThenZero = x < 0;
        if (lessThenZero) n = -n;

        while(n > 0) {
            storage.add(n % 10);
            n /= 10;
        }

        int result = 0;
        for (Integer integer : storage) {
            if (result > Integer.MAX_VALUE / 10) return 0;
            result = result * 10 + integer;
        }
        return lessThenZero ? -result : result;
    }

    /**
     * 方法与上面类似，但是这个方法更简洁，临界点判定有所不同
     * @param x
     * @return
     */
    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }


    public static void main(String[] args) {

        System.out.println(reverse(534236469));

//        System.out.println(964632435 * 10);

    }

}
