package com.michael.leetcode.gorup02;

import java.util.HashMap;
import java.util.Stack;

public class IsValid {

    public static boolean isValid(String s) {
        HashMap mappings = new HashMap<>(4);
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');

        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            if (mappings.containsKey(c)) {
                Character topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {











    }
}
