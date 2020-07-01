package leetcode_62_uniquePaths;


/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {

        /**
         * 解题思路： DP
         * 
         * 
         * 
         */
        int[][] dp = new int[m][n];

        for (int i =0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if( i ==0 || j ==0)
                    dp[i][j] = 1;
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
                
            }
        }

        return dp[m-1][n-1];

    }

    public static void main(String[] args) {
        int m = 7, n = 3;

        Solution solution = new Solution();

        int ans = solution.uniquePaths(m, n);

        System.out.println(ans);

    }
}
// @lc code=end
