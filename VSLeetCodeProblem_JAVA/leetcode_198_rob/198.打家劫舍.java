package leetcode_198_rob;
/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start

/**
 * @description: 你是一个专业的小偷，计划偷窃沿街的房屋。 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是
 *               相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在 同一晚上被小偷闯入，系统会自动报警。
 * 
 *               给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * @modifyContent:
 * @author: Maple Chan
 * @date: 2020-06-30 21:07:29
 * @version: 0.0.1
 */
class Solution {
    public int rob(int[] nums) {
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

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = { 2, 7, 9, 3, 1, };

        solution.rob(nums);

        System.out.println("finished");

    }
}
// @lc code=end
