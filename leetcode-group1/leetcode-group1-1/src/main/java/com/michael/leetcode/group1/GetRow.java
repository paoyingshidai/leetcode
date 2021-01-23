package com.michael.leetcode.group1;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 *
 * 通过次数84,353提交次数134,682
 */
public class GetRow {

    public List<Integer> getRow(int rowIndex) {

        rowIndex++;

        if (rowIndex == 0) {
            return null;
        }

        ArrayList<Integer> first = new ArrayList<>();
        first.add(1);

        if (rowIndex == 1) {
            return first;
        }

        List<Integer> pre = first;

        int i = 2;

        while (i <= rowIndex) {
            List<Integer> data = new ArrayList<>(i);
            data.add(0, 1);
            data.add(data.size() - 1, 1);

            int j = 1;
            while (j < i - 1) {
                int sum = pre.get(j - 1) + pre.get(j);
                data.add(j, sum);
                j++;
            }

            i++;
            pre = data;
        }

        return pre;
    }

    public static void main(String[] args) {
        GetRow getRow = new GetRow();

        List<Integer> row = getRow.getRow(3);

        for (Integer integer : row) {
            System.out.println(integer);
        }
    }
    
}
