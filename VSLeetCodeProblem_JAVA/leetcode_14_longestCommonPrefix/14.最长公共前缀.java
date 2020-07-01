package leetcode_14_longestCommonPrefix;

/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    /** 
     * Accepted
     * 118/118 cases passed (1 ms)
     * Your runtime beats 79.38 % of java submissions
     * Your memory usage beats 42.5 % of java submissions (37.6 MB)
    */


    public String longestCommonPrefix(String[] strs) {
        StringBuffer strPrefix = new StringBuffer();
        if(strs == null || strs.length == 0){
            return "";
        }
        if(strs.length ==1){
            return strs[0];
        }
                

        for (int i = 0; i < strs[0].length(); ++i) {
            char tmp = strs[0].charAt(i);

            for (int j = 0; j < strs.length; ++j) { // 遍历有几个字符串
                if (strs[j].length() == i || strs[j].charAt(i) != tmp) {
                    return strs[0].substring(0, i);
                }
            }
            strPrefix.append(tmp);
        }

        return strPrefix.toString();
    }


    public static void main(String[] args) {
        String[] strs = {"cc","c",};    


        Solution solution = new Solution();


        String prefix = solution.longestCommonPrefix(strs);

        System.out.println(prefix);



    }

}
// @lc code=end
