package leetcode263;

import java.util.Scanner;
/*
 * @lc app=leetcode.cn id=263 lang=java
 *
 * [263] 丑数
 */

// @lc code=start
/**
 * @description:
 * @modifyContent:
 * @author: Maple Chan
 * @date: 2020-07-01 20:21:33
 * @version: 0.0.1
 */
class Solution {
    public boolean isUgly(int num) {
        final int two = 2;
        final int three = 3;
        final int five = 5;

        if (num <= 0) {
            return false;
        }
        while (num % two == 0) {
            num = num / two;
        }
        
        while (num % three == 0) {
            num = num / three;
        }
        while (num % five == 0) {
            num = num / five;
        }

        if (num == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Scanner scanner = new Scanner(System.in);

        int num = 0;
        while (scanner.hasNext()) {
            num = scanner.nextInt();
            solution.isUgly(num);
        }
        
        scanner.close();

    }
}
// @lc code=end
