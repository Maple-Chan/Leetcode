package leetcode66;
/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */
/**
 * @description:
 * @modifyContent:
 * @author: Maple Chan
 * @date: 2020-07-08 23:04:16
 * @version: 0.0.1
 */
// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {

        // Accepted
        // 109/109 cases passed (0 ms)
        // Your runtime beats 100 % of java submissions
        // Your memory usage beats 5.63 % of java submissions (37.9 MB)
        if (null == digits || digits.length == 0) {
            return null;
        }

        int length = digits.length;

        int carry = 1;

        for (int i = length - 1; i >= 0; --i) {
            digits[i] = digits[i] + carry;
            carry = 0;

            if (digits[i] > 9) {
                carry = digits[i] / 10;
                digits[i] = digits[i] % 10;
            }
        }
        if (carry > 0) {
            int[] added = new int[length + 1];
            added[0] = carry;

            for (int i = 1; i < length; ++i) {
                added[i] = digits[i - 1];
            }
            digits = added;
        }

        return digits;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int[] digits = { 1, 2, 3 };

        digits = so.plusOne(digits);

    }
}
// @lc code=end
