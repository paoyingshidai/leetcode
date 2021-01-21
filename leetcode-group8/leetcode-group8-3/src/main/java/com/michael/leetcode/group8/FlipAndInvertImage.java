package com.michael.leetcode.group8;

/**
 * 832. 翻转图像
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * <p>
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * <p>
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
 * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * 示例 2:
 * <p>
 * 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 * 然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 说明:
 * <p>
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 */
public class FlipAndInvertImage {

    public int[][] flipAndInvertImage(int[][] A) {

        for (int[] arr : A) {
            inverse(arr);
        }
        return A;
    }

    private void inverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int temp = arr[i];
//            arr[i] = arr[j] == 1 ? 0 : 1;
//            arr[j] = temp == 1 ? 0 : 1;
            arr[i] = arr[j] ^ 1;
            arr[j] = temp ^ 1;
            i++;
            j--;
        }
    }

    public int[][] flipAndInvertImage2(int[][] A) {
        int C = A[0].length;
        for (int[] row: A)
            for (int i = 0; i < (C + 1) / 2; ++i) {
                int tmp = row[i] ^ 1;
                row[i] = row[C - 1 - i] ^ 1;
                row[C - 1 - i] = tmp;
            }

        return A;
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/flipping-an-image/solution/fan-zhuan-tu-xiang-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static void main(String[] args) {

        FlipAndInvertImage m = new FlipAndInvertImage();

        int[][] data = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        int[][] ints = m.flipAndInvertImage(data);

        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i);
            }
            System.out.println();
        }

    }

}
