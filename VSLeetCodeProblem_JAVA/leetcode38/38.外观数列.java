package leetcode38;
/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */

// @lc code=start
/**
 * @description:
 * @modifyContent:
 * @author: Maple Chan
 * @date: 2020-07-08 19:48:38
 * @version: 0.0.1
 */
class Solution {
    public String countAndSay(int n) {
        String lastString = "1";
        return countAndSayCore(1, n, new StringBuilder(lastString));
    }

    public String countAndSayCore(int index, int n, StringBuilder lastString) {
        if (index == n) {
            return lastString.toString();
        }

        StringBuilder nextString = new StringBuilder();

        char[] last = lastString.toString().toCharArray();

        int i = 0;
        int charLength = 0;
        char lastChar = last[0];
        while (i <= last.length) {

            if (i < last.length && lastChar == last[i]) {
                // lastChar = last[i];
                charLength++;
                ++i;
            } else {

                nextString.append(charLength);
                nextString.append(lastChar);
                if (i < last.length) {
                    lastChar = last[i];
                }
                charLength = 1;
                i++;
            }
        }

        return countAndSayCore(index + 1, n, nextString);
    }

    public static void main(String[] args) {
        int number = 7;

        Solution solution = new Solution();

        String ret = solution.countAndSay(number);

        System.out.println(ret);

    }
}
// @lc code=end
