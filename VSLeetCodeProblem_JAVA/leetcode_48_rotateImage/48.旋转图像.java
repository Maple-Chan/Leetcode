package leetcode_48_rotateImage;

/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        /**
         * 计算转置矩阵，Xij == Xji Accepted 21/21 cases passed (0 ms) Your runtime beats 100 %
         * of java submissions Your memory usage beats 7.69 % of java submissions (40.1
         * MB)
         */
        // 输入检查
        if (matrix == null) {
            return;
        }
        if (matrix.length == 1) {
            return;
        }

        this.transpose(matrix);
        this.switchTheSeq(matrix);

    }

    public void switchTheSeq(int[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {

                if (j < matrix.length / 2) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[i][matrix.length - 1 - j];
                    matrix[i][matrix.length - 1 - j] = tmp;

                }

            }
        }

    }

    public void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (i <= j) {
                    continue;
                }

                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // this.display(matrix);

    }

    public void display(int[][] matrix) {
        for (int[] line : matrix) {
            for (int is : line) {
                System.out.print(is + ",");
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };

        Solution solution = new Solution();
        solution.rotate(matrix);

        solution.display(matrix);

        return;

    }
}
// @lc code=end
