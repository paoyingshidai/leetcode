package com.michael.leetcode.gorup02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {


    static Map<Character, String> map = new HashMap<>();
    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        getString(digits, digits.length(), 0, result, "");
        return result;
    }

    public static void getString(String digits, int length, int index, List<String> result, String temp) {
        if (index == length) {
            result.add(temp);
            return;
        }
        String data = map.get(digits.charAt(index));
        index = index + 1;
        for (int i = 0; i < data.length(); i++) {
            temp = temp + data.charAt(i);
            getString(digits, length, index, result, temp);
            temp = temp.substring(0, temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        String orginString = "234";
        List<String> result = letterCombinations(orginString);
        result.forEach(System.out::println);
    }
}
