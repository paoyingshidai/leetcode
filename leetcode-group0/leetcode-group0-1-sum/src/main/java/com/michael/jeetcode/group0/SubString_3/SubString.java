package com.michael.jeetcode.group0.SubString_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最长子串
 */
public class SubString {

    /**
     * 暴力法
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


    /**
     * slide window 滑动窗口法
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int i = 0, j = 0, ans = 0;
        Set<Character> set = new HashSet<>();
        while(i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 优化活动窗口
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring3(String s) {
        int ans = 0, n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {

        String str = "abcadkad";

//        System.out.println(lengthOfLongestSubstring2(str));
        System.out.println(lengthOfLongestSubstring3(str));
    }


}
