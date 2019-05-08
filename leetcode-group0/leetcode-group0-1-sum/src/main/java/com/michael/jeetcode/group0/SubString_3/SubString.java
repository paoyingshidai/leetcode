package com.michael.jeetcode.group0.SubString_3;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长子串
 */
public class SubString {

    /**
     * 时间复杂度 O(n*n)
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int len = 0;
       Set map;

        for (int i = 0; i < chars.length; i++) {
            map = new HashSet();
            for (int j = i; j < chars.length; j++) {
                if (map.contains(chars[j] + "")) {
                    if (len < map.size()) {
                        len = map.size();
                    }
                    break;
                } else {
                    map.add(chars[j] + "");
                }
//                System.out.println(j + " : " + chars[j]);
                // 如果字符串到了结尾就要比较长度
                if (j == chars.length - 1) {
                    if (len < map.size()) {
                        len = map.size();
                    }
                    break;
                }
            }
//            System.out.println();
            // 如果前面的比后面的字符串长度要长，就不需要比下去了
            if (len > chars.length - 1 - i) break;
        }
        return len;
    }

    public static void main(String[] args) {

        String str = "abcabckspoi";

        System.out.println(lengthOfLongestSubstring(str));
    }


}
