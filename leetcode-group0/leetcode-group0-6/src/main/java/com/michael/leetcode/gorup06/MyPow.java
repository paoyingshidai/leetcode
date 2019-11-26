package com.michael.leetcode.gorup06;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyPow {

    public double myPow(double x, int n) {

        double result = 1.0;

        if (n > 0) {
            result = pow(x, n);
        } else if (n == 0) {
            return 1;
        } else {
            result = 1 / pow(x, -n);
        }
        return result;
    }


    /**
     * 官方推荐：快速幂乘， X^n = X^(n/2) * X^(n/2)
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {   // long / 2 之后，只有最后一步 n 才会等于 1.
            return half * half;
        } else {
            return half * half * x;
        }
    }


    /**
     * O(n) 时间超出限制
     *
     * @param x
     * @param n
     * @return
     */
    private double pow(double x, int n) {
        double result = 1.0;
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        return result;
    }

    public static void main(String[] args) {
        MyPow pow = new MyPow();
//        System.out.println(pow.myPow(2, -2));
        System.out.println(pow.myPow2(2, 3));

    }
}
