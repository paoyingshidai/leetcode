package com.michael.leetcode.group0;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Combine {

    List<List<Integer>> result = new LinkedList<>();
    int k = 0;
    int n = 0;

    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        this.n = n;
        backTrace(0, new LinkedList<>());
        return result;
    }


    public void backTrace(int index, LinkedList<Integer> temp) {
        if (temp.size() == k) {
            result.add(new LinkedList<>(temp));
            return;
        }

        for (int i = index; i < n; i++) {
            temp.add(i+1);
            backTrace(i+1, temp);
            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        System.out.println(combine.combine(4, 2));
    }
}
