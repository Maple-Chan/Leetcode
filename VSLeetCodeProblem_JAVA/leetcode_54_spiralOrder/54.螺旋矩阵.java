package leetcode_54_spiralOrder;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */
import java.util.ArrayList;
import java.util.List;


// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        /** 
         * Accepted
         * 22/22 cases passed (0 ms)
         * Your runtime beats 100 % of java submissions
         * Your memory usage beats 5.72 % of java submissions (37.3 MB)
         * 
        */

        if(matrix == null ){
            return null;
        }
        if( matrix.length == 0 || matrix[0].length == 0){
            return new ArrayList<>();
        }
        

        List<Integer> retList = new ArrayList<>();

        
        // 右，下，左，上
        int[] next_UD = { 0, 1, 0, -1 };
        int[] next_LR = { 1, 0, -1, 0 };
        int next_Index = 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[][] isVisit = new boolean[rows][cols];

        int passRow = 0;
        int passCol = 0;

        for (int i = 0; i < rows * cols; ++i) {
            if (passRow < rows && passCol < cols && passRow >= 0 && passCol >= 0 && !isVisit[passRow][passCol]) {

            } else {

                passRow = passRow - next_UD[next_Index];
                passCol = passCol - next_LR[next_Index];

                next_Index++;
                if (next_Index == 4) {
                    next_Index = 0;
                }
                passRow = passRow + next_UD[next_Index];
                passCol = passCol + next_LR[next_Index];
            }
            retList.add(matrix[passRow][passCol]);
            isVisit[passRow][passCol] = true;
            passRow = passRow + next_UD[next_Index];
            passCol = passCol + next_LR[next_Index];
        }

        return retList;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        Solution solution = new Solution();
        List<Integer> ret = solution.spiralOrder(matrix);

        for (Integer integer : ret) {
            System.out.print(integer + " ");
        }

    }
}
// @lc code=end
