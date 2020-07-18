package leetcode264;

/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

// @lc code=start
/**
 * @description:
 * @modifyContent:
 * @author: Maple Chan
 * @date: 2020-07-01 20:42:14
 * @version: 0.0.1
 */
class Solution {
    public int nthUglyNumber(int n) {
        /**
         * DP + 三指针法
         */

        int dp[] = new int[n];

        dp[0] = 1;
        int ptr2 = 0, ptr3 = 0, ptr5 = 0;

        for (int i = 1; i < n; i++) {
            int min = Math.min(dp[ptr2] * 2, Math.min(dp[ptr3] * 3, dp[ptr5] * 5));

            if (min == dp[ptr2] * 2) {
                ptr2++;
            }
            if (min == dp[ptr3] * 3) {
                ptr3++;
            }
            if (min == dp[ptr5] * 5) {
                ptr5++;
            }

            dp[i] = min;
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {

    }
}
// @lc code=end
