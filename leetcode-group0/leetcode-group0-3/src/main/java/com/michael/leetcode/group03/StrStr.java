package com.michael.leetcode.group03;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StrStr {

    public static int strStr(String haystack, String needle) {
        if (haystack.equals(needle) || needle.length() == 0 ) return 0;
        if (haystack.length() == 0 || haystack.length() < needle.length()) return -1;
        int position = -1;
        for (int i = 0; i < haystack.length(); i++) {
            int out = i;
            boolean success = false;
            boolean end = false;
            // 如果第一个单词不相等，没有必要比下去
            if (haystack.charAt(out) == needle.charAt(0)) {
                for (int j = 0; j < needle.length(); j++) {

                    // 如果不是最后一个单词不同
                    if (haystack.charAt(out)
                            != needle.charAt(j) && j < needle.length()) {
                        break;
                    } else {
                        // 如果内部循环已经到了最后
                        if (j == needle.length() - 1) {
                            position = out - needle.length() + 1;
                            success = true;
                            break;
                        } else {
                            // 外部循环已经到最后
                            if (out == haystack.length() - 1) {
                                end = true;
                                break;
                            }
                            out++;
                        }
                    }
                }
            }
            if (end) break;
            if (success) break;
        }
        return position;
    }


    /**
     * 使用 函数
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr2(String haystack, String needle) {
        int lenh = haystack.length();
        int lenn = needle.length();
        if (haystack.equals(needle) || lenn == 0 ) return 0;
        if (lenh == 0 || lenn < needle.length()) return -1;

        int position = -1;
        for (int i = 0; i < lenh - lenn + 1; i++) {
            if (haystack.substring(i, i + lenn).equals(needle))
                return position = i;
        }
        return position;
    }

    public static void main(String[] args) {

        String haystack = "mississippi";
        String needle = "issippi";

//        String haystack = "hello";
//        String needle = "ll";


        int result = strStr2(haystack, needle);

        System.out.println(result);

    }

}
