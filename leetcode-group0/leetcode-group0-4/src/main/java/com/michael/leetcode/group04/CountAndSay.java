package com.michael.leetcode.group04;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "1211"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountAndSay {

    /**
     * 递归
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String back = countAndSay(n -1);
        String r = count(back);
        return r;
    }

    /**
     * 非递归
     * @param n
     * @return
     */
    public static String countAndSay2(int n) {

        String result = "";
        for (int i = 0; i <= n; i++) {
            if (i == 1) {
                result = "1";
            } else {
                result = count(result);
            }
        }
        return result;
    }

    public static String count(String data) {
        StringBuilder builder = new StringBuilder();
        int count = 1;
        for (int j = 0; j < data.length(); j++) {
            //这里一定是if else的判断，有重复值一定先计算出重复值，因为else里面是先加上重复值
            if (j + 1 < data.length() && data.charAt(j) == data.charAt(j + 1)) {
                count++;
            } else {
                builder.append(count).append(data.charAt(j));
                count = 1;
            }
        }
        return builder.toString();
    }



    public static void main(String[] args) {

//        System.out.println(count("111221"));

//        System.out.println(count("123456"));

        System.out.println(countAndSay2(6));
//        System.out.println(countAndSay(30));     // "312211",


        /**
         *
         *
         *
         * 1.     1
         * 2.     11
         * 3.     21
         * 4.     1211
         * 5.     111221
         * 6.     312211
         *
         *
         *
         */




    }
}
