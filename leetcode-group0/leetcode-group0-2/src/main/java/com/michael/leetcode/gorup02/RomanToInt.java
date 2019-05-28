package com.michael.leetcode.gorup02;

public class RomanToInt {


    public static int romanToInt(String s) {

        int[] value = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] symbol = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int n = symbol.length;

        int result = 0;

        for(int i = n - 1; i >= 0; i--) {
            for (int k = 0; k < s.length();) {
                if (s.startsWith(symbol[i])) {
                    result = result +  value[i];
                    s = s.substring(symbol[i].length());
                    k -= s.length();
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(romanToInt("III"));


    }


}
