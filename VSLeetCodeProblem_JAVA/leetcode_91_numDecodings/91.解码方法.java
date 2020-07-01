package leetcode_91_numDecodings;

/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
/**
 * @description:
 * @modifyContent:
 * @author: Maple Chan
 * @date: 2020-07-01 08:50:52
 * @version: 0.0.1
 */
class Solution {
    public int numDecodings(String s) {

        if (s == null) {
            return -1;
        }
        /**
         * 状态转移方程
         * 
         * dp[n] = dp[n - 1] + dp[n - 2];
         * 
         * 如果，1个
         * 
         * 
         */
        char[] schar = s.toCharArray();

        int[] dp = new int[s.length() + 1];

        dp[0] = 1;
        if (schar[0] != '0')
            dp[1] = 1;
        else {
            dp[1] = 0;
        }

        for (int i = 2; i <= s.length(); ++i) {
            int n = (schar[i - 2] - '0') * 10 + (schar[i - 1] - '0');
            if (schar[i - 1] == '0' && schar[i - 2] == '0') {
                return 0;
            } else if (schar[i - 2] == '0') {
                dp[i] = dp[i - 1];
            } else if (schar[i - 1] == '0') {
                if (n > 26) {
                    return 0;
                }
                dp[i] = dp[i - 2];
            } else if (n > 26) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int ret = solution.numDecodings(
                "6065812287883668764831544958683283296479682877898293612168136334983851946827579555449329483852397155");

        System.out.println(ret);

    }
}
// @lc code=end
