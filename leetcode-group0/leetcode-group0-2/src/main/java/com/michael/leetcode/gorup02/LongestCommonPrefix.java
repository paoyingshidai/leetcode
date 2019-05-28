package com.michael.leetcode.gorup02;

public class LongestCommonPrefix {

    /**
     * 这是暴力法
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";

        String prefix = "";
        String s = strs[0];

        for (int i = 0; i < s.length(); i++) {
            prefix = prefix + s.substring(i, i+1);
            for (String str : strs) {
                if (!str.startsWith(prefix)) {
                    return  prefix.substring(0, prefix.length() - 1);
                }
            }
        }
        return prefix;
    }

    /**
     * 分治法,  通过递归实现，左边跟右边对比
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {

        if (strs == null || strs.length == 0) return "";

        return longestCommonPrefix(strs, 0, strs.length - 1);
    }


    private static String longestCommonPrefix(String[] strs, int l, int r) {

        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r) / 2;
            String left = longestCommonPrefix(strs, l, mid);
            String right = longestCommonPrefix(strs, mid + 1, r);
            return compare(left, right);
        }
    }


    private static String compare(String left, String right) {

        int min = Math.min(left.length(), right.length());

        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) return left.substring(0, i);
        }
        return left.substring(0, min);
    }



    public static void main(String[] args) {

//        String[] strs = {"flower","flow","floght"};
        String[] strs = {"a", "a"};
        System.out.println(longestCommonPrefix(strs));

//        System.out.println("flower".substring(1, 2));

    }

}
