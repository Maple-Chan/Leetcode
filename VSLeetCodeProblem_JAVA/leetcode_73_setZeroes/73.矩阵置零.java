package leetcode_73_setZeroes;
/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start

class Solution {

    public void setZeroes_inPlace(int[][] matrix) {
        /* 使用原地方法 */

        /*
         * 159/159 cases passed (1 ms)
         * Your runtime beats 99.97 % of java submissions
         * Your memory usage beats 100 % of java submissions (41.3 MB)
        */
        
        int m = matrix.length;
        int n = matrix[0].length;

        List<int[]> mark = new ArrayList<>();/* m + n */


        for (int passRow = 0; passRow < m; ++passRow) {
            for (int passCol = 0; passCol < n; ++passCol) {

                if (matrix[passRow][passCol] == 0) {

                    /*
                     * 如何加速?
                     */
                    mark.add(new int[] { passRow, passCol });
                    // break;
                }

            }
        }
        for (int i = 0; i < mark.size(); ++i) {
            for(int row=0;row<m;++row){
                matrix[row][mark.get(i)[1]] = 0;
            }
            for(int col = 0;col<n;++col){

                matrix[mark.get(i)[0]][col] = 0;
            }
        }

    }

    
    /*
     * 一个直接的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。 一个简单的改进方案是使用 O(m + n)
     * 的额外空间，但这仍然不是最好的解决方案。 你能想出一个常数空间的解决方案吗？
     */
    public void setZeroes(int[][] matrix) {
        /*
            将为0的那个数的所在行第一个=> 0，所在列的第一个=>0.
        */


    }



    public void display( int matrix[][]){

        int m = matrix.length;
        int n = matrix[0].length;

        for (int passRow = 0; passRow < m; ++passRow) {
            for (int passCol = 0; passCol < n; ++passCol) {
                System.out.print(matrix[passRow][passCol]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // int matrix[][] = {
        //     {1,1,1},
        //     {1,0,1},
        //     {1,1,1}
        // };

        int matrix[][] = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        Solution solution = new Solution();
        solution.display(matrix);

        solution.setZeroes(matrix);

        solution.display(matrix);

    }
}
// @lc code=end
