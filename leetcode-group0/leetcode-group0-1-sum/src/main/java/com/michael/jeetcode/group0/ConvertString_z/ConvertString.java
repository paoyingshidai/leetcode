package com.michael.jeetcode.group0.ConvertString_z;

import java.util.ArrayList;
import java.util.List;

/**
 * z 形的字符串的转换
 */
public class ConvertString {

    /**
     * 解题思路：
     * numRows: 阶数，
     * i: 第 i 阶
     * 每一阶字母的间隔有一定的规律：
     *      奇数步间隔为 K(奇) = 2 * (numRows - i)
     *      偶数步间隔为 K(偶) = 2 * (i- 1)
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {

        if (s == null || "".equals(s)) return "";
        if (numRows == 1) return s;

        StringBuilder result = new StringBuilder();
        // i: 第 i 阶
        for (int i = 1; i <= numRows; i++) {
            boolean odd = true; // 奇数
            if (i > s.length()) break;
            int index = i - 1;                      // 第 i 阶的第一个字母的位置
            result = result.append(s.charAt(index));

            while(index < s.length() - 1) {
                if (odd) {
                    int width = 2 * (numRows - i);  // 相差距离(奇数)
                    if (width != 0) {
                        index = index + width;
                        if (index >= s.length()) break;
                        result = result.append(s.charAt(index));
                    }
                    odd = false;
                } else {
                    int width2 = 2 * (i - 1);       // 相差距离（偶数）
                    if (width2 != 0) {
                        index = index + width2;
                        if (index >= s.length()) break;
                        result = result.append(s.charAt(index));
                    }
                    odd = true;
                }
            }
        }
        return result.toString();
    }


    /**
     * 阶梯思路: 每一阶对应一个 StringBuilder， curRow 每循环一次会变动一次，变动的方向根据当前行是波峰还是波谷，每到两个极点的时候都会反向
     * @param s
     * @param numRows
     * @return
     */
    public static String convert2(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;             // 第 i 阶， 每一阶对应一个 StringBuilder,
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;   // curRow 滑动到波峰或者低谷的时候反向
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }


    /**
     * 按行访问
     * @param s
     * @param numRows
     * @return
     */
    public static String convert3(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }





    public static void main(String[] args) {

//        String insert = "ABCDEFGHIJKLMNO";
//        String insert = "LEETCODEISHIRING";
//        if (convert(insert, 3).equals("LCIRETOESIIGEDHN")) {
//            System.out.println("正确");
//        } else {
//            System.out.println("错误");
//        }
//
//        System.out.println();
//
//        String insert2 = "LEETCODEISHIRING";
//        if (convert(insert2, 4).equals("LDREOEIIECIHNTSG")) {
//            System.out.println("正确");
//        } else {
//            System.out.println("错误");
//        }


        String insert3 = "ABCDEF";
        if (convert2(insert3, 4).equals("ABFCED")) {
            System.out.println("正确");
        } else {
            System.out.println("错误");
        }

//        System.out.println(convert("AB", 1));
//        System.out.println(convert("A", 2));

    }

}
