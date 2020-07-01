package leetcode_67_addBinary;

import java.util.*;

/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */
// 111 + 111 1110
// @lc code=start
class Solution {
    public String addBinary(String a, String b) {

        /**
         * 解题思路： 从最右边开始加，
         * 
         */

        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();

        char[] outChar = new char[a.length() + b.length()];
        Arrays.fill(outChar, '0');
        int carry = 0;

        int indexA = aChar.length - 1;
        int indexB = bChar.length - 1;
        int i = outChar.length - 1;

        while (i >= 0) {
            int addNumber = 0;
            int bitNumber = outChar[i] - '0';

            if (indexA < 0 && indexB < 0) {
                break;
            }

            if (indexA >= 0) {
                addNumber = addNumber + (aChar[indexA] - '0');
            }
            if (indexB >= 0) {
                addNumber = addNumber + (bChar[indexB] - '0');
            }

            addNumber = addNumber + bitNumber;

            outChar[i] = (char) ((addNumber % 2) + '0');

            outChar[i - 1] = (char) ((addNumber / 2) + '0'); // 进位

            indexA--;
            indexB--;
            i--;
        }

        /**
         * 转换成开头没有0的
         * 
         */
        StringBuffer nBuffer = new StringBuffer();

        boolean isHead = true;
        for (int j = 0; j < outChar.length; ++j) {
            if (outChar[j] == '0' && isHead)
                continue;

            else {
                isHead = false;
            }

            nBuffer.append(outChar[j]);
        }

        if (nBuffer.length() == 0) {
            nBuffer.append('0');
        }

        return nBuffer.toString();
    }

    public static void main(String[] args) {

        String a = "1010";
        String b = "1011";

        Solution solution = new Solution();

        String ret = solution.addBinary(a, b);

        System.out.println(ret);
    }
}
// @lc code=end
