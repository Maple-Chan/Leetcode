package leetcode_28_strStr;
/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */


// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        /**
         * Accepted 
         * 74/74 cases passed (2 ms) 
         * Your runtime beats 49.24 % of java submissions 
         * Your memory usage beats 5.43 % of java submissions (39.5 MB)
         * 
         */

        if (needle == null || needle.length() == 0) {
            return 0;
        }

        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();
        int patternLength = needleArray.length;

        if (haystackArray.length == 0 && needleArray.length == 0) {
            return 0;
        }

        // int indexOfHayStack = 0;
        int indexOfNeedle = 0;
        int startIndex = 0;
        for (int i = 0; i < haystackArray.length; i++) {
            if (haystackArray[i] == needleArray[indexOfNeedle]) {
                if (indexOfNeedle == 0) {
                    startIndex = i;
                }

                indexOfNeedle++;

                if (indexOfNeedle == patternLength) {
                    return startIndex;
                }
            } else {
                if (indexOfNeedle != 0) {
                    i = startIndex;
                }
                indexOfNeedle = 0;

            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String haystack = "mississippi", needle = "pi";

        Solution solution = new Solution();

        int ret = solution.strStr(haystack, needle);

        System.out.println(ret);
    }
}
// @lc code=end
