package com.michael.leetcode.gorup06;

import java.util.ArrayList;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolveNQueens {

//    https://leetcode-cn.com/problems/n-queens/solution/nhuang-hou-by-leetcode/

    int rows[];         // 列占位

    /**
     * 这里的对角线表示方式比较微妙
     */
    // "hill" diagonals， 主对角线 '\'  row - col + 2*n
    int hills[];

    // "dale" diagonals   次对角线 '/' 这里从 0 开始 row + col
    int dales[];

    // 皇后的个数
    int n;

    // output
    List<List<String>> output = new ArrayList();
    // queens positions
    int queens[];

    /** 判断是否可以相互攻击 */
    public boolean isNotUnderAttack(int row, int col) {
        int res = rows[col] + hills[row - col + 2 * n] + dales[row + col]; // 列 + 对角线都不能有皇后
        return (res == 0) ? true : false;
    }

    /** 放置皇后 */
    public void placeQueen(int row, int col) {
        queens[row] = col;              // 皇后的位置，包含了行列信息
        rows[col] = 1;                  // 列占位
        hills[row - col + 2 * n] = 1;   // 主对角线占位
        dales[row + col] = 1;           // 次对角线占位
    }

    /** 移除皇后 */
    public void removeQueen(int row, int col) {
        queens[row] = 0;
        rows[col] = 0;
        hills[row - col + 2 * n] = 0;
        dales[row + col] = 0;
    }

    /** 记下一个符合的结果 */
    public void addSolution() {
        List<String> solution = new ArrayList<String>();
        for (int i = 0; i < n; ++i) {
            int col = queens[i];
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < col; ++j) sb.append(".");
            sb.append("Q");
            for(int j = 0; j < n - col - 1; ++j) sb.append(".");
            solution.add(sb.toString());
        }
        output.add(solution);
    }

    /** 回溯 */
    /**
     * n 皇后问题的关键并不是回溯算法，而是问题的表述，如何用数组来表示 皇后的位置
     *
     *
     * @param row
     */
    public void backtrack(int row) {
        for (int col = 0; col < n; col++) {
            if (isNotUnderAttack(row, col)) {
                placeQueen(row, col);
                // if n queens are already placed
                if (row + 1 == n) addSolution();
                    // if not proceed to place the rest
                else backtrack(row + 1);
                // backtrack
                removeQueen(row, col);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        rows = new int[n];
        hills = new int[4 * n - 1];
        dales = new int[2 * n - 1];
        queens = new int[n];

        backtrack(0);
        return output;
    }

    public static void main(String[] args) {

        SolveNQueens solveNQueens = new SolveNQueens();

        List list = solveNQueens.solveNQueens(4);

        System.out.println(list);

    }

}
