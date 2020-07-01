package leetcode_64_minPathSum;

/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {


        /** 
         * 
         * Accepted
         * 61/61 cases passed (4 ms)
         * Your runtime beats 36.77 % of java submissions
         * Your memory usage beats 31.82 % of java submissions (42.3 MB)
         * 
        */

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; ++j) {

                if(i ==0 & j==0){
                    continue;
                }

                if(i ==0){
                    grid[0][j] = grid[0][j-1] + grid[0][j];
                    continue;
                }
                if(j == 0){
                    grid[i][0] =  grid[i][0] + grid[i-1][0];
                    continue;
                }

                grid[i][j] = Math.min(grid[i][j] +grid[i-1][j] , grid[i][j] +grid[i][j-1]);


            }
        }

        return grid[m-1][n-1];

    }


    public static void main(String[] args) {
        int [][] grid = new int[][]{
            {1,3,1},{1,5,1},{4,2,1}
        };

        Solution solution = new Solution();

        int out = solution.minPathSum(grid);


        System.out.println(out);;

        
    }
}
// @lc code=end
