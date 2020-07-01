package leetcode_74_searchMatrix;
/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
/**
 * @description:
 * @modifyContent:
 * @author: Maple Chan
 * @date: 2020-07-01 08:50:31
 * @version: 0.0.1
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 1. 缩小领域法
        /**
         * Accepted 136/136 cases passed (0 ms) Your runtime beats 100 % of java
         * submissions Your memory usage beats 94.29 % of java submissions (39.8 MB)
         * 
         */

        // 2. 标准的二分查找模板，将二维矩阵拖为一维矩阵，然后就是一个有序的一维数组了，利用二分查找就行
        if (matrix == null || matrix.length < 1) {
            return false;
        }

        if (matrix[0] == null || matrix[0].length < 1) {
            return false;
        }

        /*
         * 有序矩阵
         */

        int m = matrix.length;
        int n = matrix[0].length;

        int line = -1;
        for (int i = 0; i < m; ++i) {
            if (target <= matrix[i][n - 1]) {
                line = i;
                break;
            }
        }

        if (-1 == line) {
            return false;
        }

        /* 可以用二分查找一行中的有序数据 */
        int mid;
        int high = n - 1;
        int low = 0;

        while (low <= high) {
            mid = (high + low + 1) / 2;
            if (matrix[line][mid] == target) {
                return true;
            } else if (matrix[line][mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return false;
    }

    public static void main(String[] args) {

        int target = 34;
        // int [][] matrix = new int[][]{
        // {1, 3, 5, 7},
        // {10, 11, 16, 20},
        // {23, 30, 34, 50}
        // };
        int[][] matrix = new int[][] { null };

        if (matrix[0] == null) {
            System.out.println("ppp");
        }

        Solution solution = new Solution();

        solution.searchMatrix(matrix, target);

    }

}
// @lc code=end
