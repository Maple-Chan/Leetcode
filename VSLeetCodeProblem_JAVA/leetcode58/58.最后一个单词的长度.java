package leetcode58;
/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
/**
 * @description:
 * @modifyContent:
 * @author: Maple Chan
 * @date: 2020-07-08 20:39:51
 * @version: 0.0.1
 */
class Solution {
    public int lengthOfLastWord(String s) {

        if (null == s || s.length() == 0) {
            return 0;
        }

        char[] charlist = s.toCharArray();

        int length = 0;
        int retlen = 0;
        for (int i = 0; i < charlist.length; i++) {
            if (charlist[i] != ' ') {
                length++;
                retlen = length;
            } else if (charlist[i] == ' ') {
                length = 0;
            }

        }

        return retlen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "b   a    ";

        int ret = solution.lengthOfLastWord(s);

        System.out.println(ret);
    }
}
// @lc code=end
