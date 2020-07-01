package leetcode_20_isValid;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */
import java.util.*;

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        /**
         * 解题思路： 如果是空格则跳过 如果是左括号则放入栈 如果是有括号则找栈顶，如果是一对，则栈顶出栈。 如果不是一对，则返回false
         * 
         * 遍历完之后，如果栈里面只有空格或者为空则返回true。
         * 
         * Accepted 76/76 cases passed (3 ms) Your runtime beats 40.3 % of java
         * submissions Your memory usage beats 5.48 % of java submissions (37.8 MB)
         * 
         * 
         */
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ' ') {
                continue;
            } else if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));

            } else if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {

                if (stack.size() <= 0) {
                    return false; // 如果有有括号的情况，没了左括号，那么就是无效的一组
                }

                Character top = stack.peek();

                if (mEqual(top, s.charAt(i))) {
                    stack.pop();
                } else {
                    return false;
                }

            }
        }

        if (stack.size() == 0) {
            return true;
        }

        return false;
    }

    private boolean mEqual(Character left, Character right) {
        // System.out.println(left.equals(new Character('(')));
        // System.out.println(right.equals(new Character(')')));

        if (left.equals(new Character('(')) && right.equals(new Character(')')) || left.equals('[') && right.equals(']')
                || left.equals('{') && right.equals('}')) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "]";

        boolean out = solution.isValid(s);

        System.out.println(out);

        return;
    }
}
// @lc code=end
