package leetcode_70_climbStairs;

/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {

        /** 
         * Accepted
         * 45/45 cases passed (0 ms)
         * Your runtime beats 100 % of java submissions
         * Your memory usage beats 5.66 % of java submissions (36 MB)
        */

        int dp[] = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i=2;i<=n;++i){
            dp[i] = dp[i-1] + dp[i-2];
        }

       return dp[n];
    }


 

    public static void main(String[] args) {
        
        Solution solution = new Solution();


        int ret = solution.climbStairs(2);

        System.out.println(ret);


    }
}
// @lc code=end

