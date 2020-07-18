package leetcode69;
/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
/**
 * @description:
 * @modifyContent:
 * @author: Maple Chan
 * @date: 2020-07-09 22:21:47
 * @version: 0.0.1
 */
class Solution {
    public int mySqrt(int x) {

        // 1. 数学推算
        // sqrt(x) = x^1/2 = e^ln(x^1/2) = e^1/2(lnx)
        // int ret = (int) Math.exp(0.5 * Math.log(x));

        // 2. 二分查找
        // k^2 < x
        //
        int left = 0;
        int right = x;
        int mid = left + (right - left) / 2;
        int ans = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;

            if ((long) mid * mid < x) {
                ans = mid;
                left = mid + 1;

            } else if ((long) mid * mid > x) {
                right = mid - 1;

            } else {
                return mid;
            }
        }

        // (int) Math.sqrt(x);

        return ans;
    }

}
// @lc code=end
