package leetcode264;
import java.util.Scanner;

/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

// @lc code=start
/**
 * @description:   该方法超时！！！
 * @modifyContent:
 * @author: Maple Chan
 * @date: 2020-07-01 20:42:14
 * @version: 0.0.1
 */
class Solution2 {
    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;

        int index = 1;
        int number = 2;

        while (index < n) {
            if (isUgly(number)) {
                uglyNumbers[index] = number;
            } else {
                number++;
                continue;
            }
            number++;
            index++;
        }
        return uglyNumbers[n - 1];
    }

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
        Solution2 solution = new Solution2();

        Scanner scanner = new Scanner(System.in);

        int num = 0;
        while (scanner.hasNext()) {
            num = scanner.nextInt();
            solution.nthUglyNumber(num);
        }
        scanner.close();

    }
}
// @lc code=end
