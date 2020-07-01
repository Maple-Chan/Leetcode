package leetcode_63_uniquePathsWithObstacles;

/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {


        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int [][]  dp= new int[m][n];

        /** 
         * 初始化，如果遇到1，那么边界的后头就不用考虑了。
         * 
        */
        for (int i =0; i < m; ++i) {

            if(obstacleGrid[i][0] == 1)
                break;
            else{
                dp[i][0] = 1;
            }

        }
        for (int j = 0; j < n; ++j) {

            if(obstacleGrid[0][j] == 1){
                break;
            }
            else{
                dp[0][j] = 1;
            }

        }

        /** 
         * 如果遇到1障碍，就标志不可达。
         * 不是，就加上到左或者上的路径数，如果左或上不可达，也就是+0，路径不增多。
         * 
        */
        for (int i =1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {

                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }

                
            }
        }

        return dp[m-1][n-1];


    }


    public static void main(String[] args) {
        


    }
}
// @lc code=end

