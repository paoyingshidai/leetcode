package com.michael.leetcode.group0;

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) return false;

        int index = searchIndex(matrix, target);
        if (-1 == index) return false;

        return search(matrix[index], target);
    }


    public boolean search(int[] matrix, int target) {

        int right = matrix.length;
        int left = 0;
        while (left < right) {

            int mid = (left + right) >>> 1;

//            if (mid > matrix.length - 1) return false;

            if (matrix[mid] == target) {
                return true;
            } else if (matrix[mid] > target) {
                right--;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    /**
     * 获取符合条件的一维数组
     *
     * @param matrix
     * @param target
     * @return
     */
    public int searchIndex(int[][] matrix, int target) {

        int right = matrix.length;
        int left = 0;

        while (left < right) {

            int mid = (left + right) >>> 1;

            int[] mar = matrix[mid];
            if (mar == null || mar.length == 0) return -1;

            if (target < mar[0]) {
                right--;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {

        int[][] matrix =
                {
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 50}
                };

        int[][] ma = {{1},{2,3},{4,5,6,9}, {100}};

        SearchMatrix matrix1 = new SearchMatrix();

        System.out.println(matrix1.searchMatrix(ma, 1));

    }
}
