package leetcode_213_rob2;
/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

import java.util.Arrays;

// @lc code=start
/**
 * @description: 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * @modifyContent:
 * @author: Maple Chan
 * @date: 2020-06-30 21:51:17
 * @version: 0.0.1
 */
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (1 == nums.length) {
            return nums[0];
        }

        return Math.max(robCore(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                robCore(Arrays.copyOfRange(nums, 1, nums.length)));

    }

    private int robCore(int[] nums) {
        /**
         * 思路： 分成两种情况，上一个有偷，上一个没偷。 如果上一个没偷，则可偷可不偷。 如果上一个偷了，那就不能偷。
         * 
         * 记录每种情况的获得的钱。 0表示没偷钱 1表示偷了
         * 
         */

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[][] dp = new int[nums.length][2];

        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }

        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

}
// @lc code=end
