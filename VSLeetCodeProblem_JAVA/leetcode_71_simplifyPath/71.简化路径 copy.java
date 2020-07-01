package leetcode_71_simplifyPath;

import java.util.Stack;

/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {

    /**
     * 254/254 cases passed (5 ms) Your runtime beats 94.19 % of java submissions
     * Your memory usage beats 9.52 % of java submissions (40.1 MB)
     * 
     * @param path
     * @return
     */

    public String simplifyPath(String path) {
        if (null == path) {
            return path;
        }
        if (1 == path.length() && !path.equals("/")) {
            return "/";
        }

        StringBuilder retStringBuilder = new StringBuilder();
        Stack<String> assistStack = new Stack<>();

        String[] pathArray = path.split("/");

        for (String item : pathArray) {

            if ("..".equals(item)) {
                if (assistStack.size() > 0) {
                    assistStack.pop();
                }

            } else if (item.equals(".") || item.equals("")) {
                continue;
            } else {
                assistStack.push(item);
            }
        }

        for (String item : assistStack) {
            retStringBuilder.append("/");
            retStringBuilder.append(item);
        }

        // retStringBuilder.append("/");
        if (0 == retStringBuilder.length()) {
            retStringBuilder.append("/");
        }

        return retStringBuilder.toString();
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String ret = solution.simplifyPath("/a/./b/../../c/");

        System.out.println(ret);

    }
}
// @lc code=end
