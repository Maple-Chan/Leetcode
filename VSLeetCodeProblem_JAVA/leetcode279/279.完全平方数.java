package leetcode279;
/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

import java.util.Arrays;

// @lc code=start

class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = 0;
        int squareNumbersLength = (int) Math.sqrt(n) + 1;
        int squareNumbers[] = new int[squareNumbersLength];
        for (int i = 0; i < squareNumbersLength; i++) {
            squareNumbers[i] = i * i;
        }

        //当前的完全平方数的个数，就是上一个数的+1，如果当前就是完全平方数，那么就从dp[0]开始。
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < squareNumbersLength; ++j) {
                if(i < squareNumbers[j]){
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - squareNumbers[j]] + 1);
            }
        }

        return dp[n];
    }
}
// @lc code=end
