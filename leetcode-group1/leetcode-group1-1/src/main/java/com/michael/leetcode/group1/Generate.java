package com.michael.leetcode.group1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * 通过次数146,675提交次数210,168
 */
public class Generate {


    /**
     * 非递归
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate2(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }

        ArrayList<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);

        if (numRows < 2) {
            return result;
        }

        int i = 2;
        List<Integer> pre = result.get(result.size() - 1);
        while (i <= numRows) {
            List<Integer> data = new ArrayList<>(i);
            data.add(0, 1);
            data.add(data.size() - 1, 1);

            int j = 1;
            while (j < i - 1) {
                int sum = pre.get(j - 1) + pre.get(j);
                data.add(j, sum);
                j++;
            }
            result.add(data);

            i++;
            pre = data;
        }

        return result;
    }

    /**
     * 递归
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }

        ArrayList<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);

        if (numRows < 2) {
            return result;
        }

        doGen(2, first, result, numRows);

        return result;
    }

    private void doGen(int row, List<Integer> preRow, List<List<Integer>> result, int end) {

        List<Integer> data = new ArrayList<>(row);
        data.add(0, 1);
        data.add(data.size() - 1, 1);

        int j = 1;
        while (j < row - 1) {

            int sum = preRow.get(j - 1) + preRow.get(j);
            data.add(j, sum);
            j++;
        }
        result.add(data);

        if (row != end) {
            doGen(row+1, data, result, end);
        }
    }


    public static void main(String[] args) {

        Generate generate = new Generate();

        List<List<Integer>> result = generate.generate2(5);

        for (List<Integer> re : result) {
            for (Integer integer : re) {
                System.out.println(integer);
            }
            System.out.println();
        }


    }

}
