package leetcode300;
/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长上升子序列
 */

import java.util.Arrays;

// @lc code=start
/**
 * @description:
 * @modifyContent:
 * @author: Maple Chan
 * @date: 2020-07-06 21:19:49
 * @version: 0.0.1
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        // LogN2

        if (null == nums || 0 == nums.length) {
            return 0;
        }

        // 0 记录最大值，1 记录上一个至的最大值
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        dp[0] = 1;
        int maxans = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
            
        }

        return maxans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };

        solution.lengthOfLIS(nums);
    }

}
// @lc code=end
