package leetcode221;
/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
/**
 * @description:
 * @modifyContent:
 * @author: Maple Chan
 * @date: 2020-07-01 18:39:01
 * @version: 0.0.1
 */
class Solution {
    public int maximalSquareRat(char[][] matrix) {

        /**
         * 
         */
        // 暴力
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int maxSide = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    maxSide = Math.max(1, maxSide);
                    int currentMaxSide = Math.min(rows - i, cols - j);

                    for (int k = 1; k < currentMaxSide; k++) {
                        boolean stillSquare = true;

                        if (matrix[i + k][j + k] == '0') {
                            break;
                        }

                        for (int l = 0; l < k; l++) {
                            if (matrix[i + k][j + l] == '0' || matrix[i + l][j + k] == '0') {
                                stillSquare = false;
                                break;
                            }
                        }
                        if (stillSquare) {
                            maxSide = Math.max(maxSide, k + 1);
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        return maxSide * maxSide;
    }

    public int maximalSquare(char[][] matrix) {
        final char number1 = '1';
        /**
         * 
         */
        // 暴力
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int maxSide = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int dp[][] = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (number1 == matrix[i][j]) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide * maxSide;
    }
    // public static void main(String[] args) {
    // Solution solution = new Solution();
    // // int[][] matrix = { { 1, 0, 1, 0, 0 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1
    // }, {
    // // 1, 0, 0, 1, 0 } };
    // char[][] matrix = { { '1', '1', '1', '1', '1', '1', '1', '1' }, { '1', '1',
    // '1', '1', '1', '1', '1', '0' },
    // { '1', '1', '1', '1', '1', '1', '1', '0' }, { '1', '1', '1', '1', '1', '0',
    // '0', '0' },
    // { '0', '1', '1', '1', '1', '0', '0', '0' } };

    // solution.maximalSquare(matrix);
    // }
}
// @lc code=end
